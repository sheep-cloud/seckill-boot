package cn.colg.service;

import java.util.List;

import cn.colg.dto.Exposer;
import cn.colg.dto.SeckillExecution;
import cn.colg.entity.Seckill;

/**
 * 业务接口：站在“使用者”角度设计接口 <br />
 * 
 * 三个方面： <br />
 * 1. 方法定义粒度 <br />
 * 2. 参数 <br />
 * 3. 返回类型{return 类型/异常;}
 *
 * @author colg
 */
public interface SeckillService {

	/**
	 * 查询所有库存商品
	 * 
	 * @return
	 */
	List<Seckill> querySeckill();

	/**
	 * 根据id查询库存商品
	 * 
	 * @param seckillId
	 * @return
	 */
	Seckill findById(String seckillId);

	/**
	 * 暴露秒杀地址
	 * 
	 * @param seckillId
	 * @return
	 */
	Exposer exportSeckillUrl(String seckillId);

	/**
	 * 执行秒杀
	 * 
	 * @param seckillId
	 * @param phone
	 * @param md5
	 * @return
	 */
	SeckillExecution executeSekill(String seckillId, String phone, String md5);

}
