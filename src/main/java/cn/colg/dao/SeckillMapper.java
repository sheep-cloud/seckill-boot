package cn.colg.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.Seckill;
import tk.mybatis.mapper.common.Mapper;

public interface SeckillMapper extends Mapper<Seckill> {

	Seckill findById(@Param("seckillId") String seckillId);

	int reduceNumber(@Param("seckillId") String seckillId, @Param("killTime") Date date);
}