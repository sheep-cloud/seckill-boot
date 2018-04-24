package cn.colg.dao;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.SuccessKilled;
import tk.mybatis.mapper.common.Mapper;

/**
 * 商品秒杀 - dao
 *
 * @author colg
 */
public interface SuccessKilledMapper extends Mapper<SuccessKilled> {

	/**
	 * 新增秒杀信息
	 * 
	 * @param seckillId
	 * @param phone
	 * @return
	 */
	int insertSuccessKilled(@Param("seckillId") String seckillId, @Param("userPhone") String phone);

	/**
	 * 根据商品id和用户手机号查询秒杀信息
	 * 
	 * @param seckillId
	 * @param phone
	 * @return
	 */
	SuccessKilled findBySeckillIdAndPhone(@Param("seckillId") String seckillId, @Param("userPhone") String phone);
}