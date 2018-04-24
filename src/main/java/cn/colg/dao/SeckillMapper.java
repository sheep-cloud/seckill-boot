package cn.colg.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.Seckill;
import tk.mybatis.mapper.common.Mapper;

/**
 * 秒杀 - dao
 *
 * @author colg
 */
public interface SeckillMapper extends Mapper<Seckill> {

	/**
	 * 根据id获取商品
	 * 
	 * @param seckillId
	 * @return
	 */
	Seckill findById(@Param("seckillId") String seckillId);

	/**
	 * 根据日期减少商品数量
	 * 
	 * @param seckillId
	 * @param date
	 * @return
	 */
	int reduceNumber(@Param("seckillId") String seckillId, @Param("killTime") Date date);
}