package cn.colg.exception;

import cn.colg.enums.ExceptionEnum;

/**
 * 自定义业务异常
 *
 * @author colg
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer code;

	public ServiceException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMsg());
		this.code = exceptionEnum.getCode();
	}

	public ServiceException(String message, Integer code) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
