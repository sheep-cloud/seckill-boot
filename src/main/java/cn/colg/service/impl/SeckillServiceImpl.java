package cn.colg.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.colg.core.BaseServiceImpl;
import cn.colg.dto.Exposer;
import cn.colg.dto.SeckillExecution;
import cn.colg.entity.Seckill;
import cn.colg.entity.SuccessKilled;
import cn.colg.enums.ExceptionEnum;
import cn.colg.result.ResultUtil;
import cn.colg.service.SeckillService;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * 
 *
 * @author colg
 */
@Service
public class SeckillServiceImpl extends BaseServiceImpl implements SeckillService {

	/**
	 * md5盐值字符串，用于混淆md5
	 */
	@Value("${SLAT}")
	private String slat;

	@Override
	public List<Seckill> querySeckill() {
		return seckillMapper.selectAll();
	}

	@Override
	public Seckill findById(String seckillId) {
		return seckillMapper.selectByPrimaryKey(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(String seckillId) {
		Seckill seckill = seckillMapper.selectByPrimaryKey(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}

		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		// 系统当前时间
		Date nowTime = new Date();
		// 判断当前系统时间是否在秒杀期间
		long now = nowTime.getTime();
		if (now < startTime.getTime() || now > endTime.getTime()) {
			return new Exposer(false, seckillId, now, startTime.getTime(), endTime.getTime());
		}

		// 转换特定字符串的过程，不可逆
		String md5 = getMd5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	/**
	 * 根据库存商品id和盐值生成md5
	 * 
	 * @param seckillId
	 * @return
	 */
	private String getMd5(String seckillId) {
		String data = seckillId + "/" + slat;
		String md5 = SecureUtil.md5(data);
		return md5;
	}

	/**
	 * <pre>
	 * 使用注解控制事务方法的优点：
	 * 	1：开发团队达成一致约定，明确标注事务方法的变成风格。
	 * 	2：保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部。
	 * 	3：不是所有的方法都需要事务，如：只有一条修改操作，只读操作不需要事务控制。
	 * </pre>
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public SeckillExecution executeSekill(String seckillId, String phone, String md5) {
		if (!StrUtil.isBlank(seckillId)) {
			ResultUtil.throwException(200, "手机号码不存在！");
		}

		if (StrUtil.isBlank(md5) || !md5.equals(getMd5(seckillId))) {
			// md5不同，秒杀的数据被改写
			return new SeckillExecution(seckillId, ExceptionEnum.DATA_REWRITE);
		}

		// 执行秒杀逻辑：减库存 + 记录购买行为
		// 减库存
		int updateCount = seckillMapper.reduceNumber(seckillId, new Date());
		if (updateCount <= 0) {
			// 没有更新到记录，秒杀结束
			return new SeckillExecution(seckillId, ExceptionEnum.END);
		}

		// 记录用户购买行为，唯一：seckillId，userPhone
		int insertCount = successKilledMapper.insertSuccessKilled(seckillId, phone);
		if (insertCount <= 0) {
			// 重复秒杀
			return new SeckillExecution(seckillId, ExceptionEnum.REPEAT_KILL);
		}

		// 秒杀成功
		SuccessKilled successKilled = successKilledMapper.findBySeckillIdAndPhone(seckillId, phone);
		return new SeckillExecution(seckillId, ExceptionEnum.SUCCESS, successKilled);
	}

}
