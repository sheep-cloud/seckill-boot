package cn.colg.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.colg.enums.ExceptionEnum;
import cn.colg.result.ResultBean;
import cn.colg.result.ResultUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * 异常的统一管理
 *
 * @author colg
 */
@RestControllerAdvice
public class ExceptionHandle {

	private static final Log log = LogFactory.get();

	/**
	 * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public ResultBean execptionGet(Exception e, HttpServletRequest request) {
		// 业务异常
		if (e instanceof ServiceException) {
			ServiceException se = (ServiceException) e;
			log.info(request.getRequestURL() + "{}", "");
			return ResultUtil.fail(se.getCode(), se.getMessage());
		}

		// 系统异常
		log.error(e);
		return ResultUtil.fail(ExceptionEnum.UNKNOW_ERROR);
	}
}
