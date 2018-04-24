package cn.colg.result;

import cn.colg.enums.ExceptionEnum;
import cn.colg.exception.ServiceException;

/**
 * 响应工具类
 *
 * @author colg
 */
public class ResultUtil {

	/**
	 * 返回成功，传入返回体具体出參
	 * 
	 * @param data
	 * @return
	 */
	public static ResultBean success(Object data) {
		return new ResultBean()
					.setCode(ResultBean.SUCCESS)
					.setData(data);
	}
	
	/**
	 * 提供给部分不需要出參的接口
	 * 
	 * @return
	 */
	public static ResultBean success() {
		return new ResultBean();
	}
	
	/**
	 * 自定义错误信息
	 * 
	 * @param msg
	 * @return
	 */
	public static ResultBean fail(Integer code, String msg) {
		return new ResultBean()
					.setCode(code)
					.setMsg(msg);
	}


	/**
	 * 返回异常信息，在已知的范围内
	 * 
	 * @param exceptionEnum
	 * @return
	 */
	public static ResultBean fail(ExceptionEnum exceptionEnum) {
		return new ResultBean()
					.setCode(exceptionEnum.getCode())
					.setMsg(exceptionEnum.getMsg());
	}
	
	/**
	 * 抛出枚举异常
	 * 
	 * @param exceptionEnum
	 */
	public static void throwException(ExceptionEnum exceptionEnum) {
		throw new ServiceException(exceptionEnum);
	}
	
	/**
	 * 抛出自定义异常
	 * 
	 * @param code
	 * @param msg
	 */
	public static void throwException(Integer code, String msg) {
		throw new ServiceException(msg, code);
	}
	

}
