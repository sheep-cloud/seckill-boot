package cn.colg.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.colg.dao.SeckillMapper;
import cn.colg.dao.SuccessKilledMapper;

/**
 * ServiceImpl层基础类，用于抽取注入的Mapper
 *
 * @author Yang Lei
 */
public abstract class BaseServiceImpl {

	@Autowired
	protected SeckillMapper seckillMapper;
	@Autowired
	protected SuccessKilledMapper successKilledMapper;
}
