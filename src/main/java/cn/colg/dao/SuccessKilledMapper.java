package cn.colg.dao;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.SuccessKilled;
import tk.mybatis.mapper.common.Mapper;

public interface SuccessKilledMapper extends Mapper<SuccessKilled> {

	int insertSuccessKilled(@Param("seckillId") String seckillId, @Param("userPhone") String phone);

	SuccessKilled findBySeckillIdAndPhone(@Param("seckillId") String seckillId, @Param("userPhone") String phone);
}