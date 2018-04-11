package cn.colg.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.colg.service.SeckillService;

/**
 * Controller 的基类，用于抽取注入的Service
 * 
 * @author Yang Lei
 */
public abstract class BaseController {

	@Autowired
	protected SeckillService seckillService;
}
