package cn.colg.result;

import java.io.Serializable;

public class ResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final Integer SUCCESS = 0;

	/**
	 * 错误代码，状态值：0 ：成功，其他数值代表失败
	 */
	private Integer code;

	/**
	 * 错误信息
	 */
	private String msg;

	/**
	 * 结果集
	 */
	private Object data;

	public Integer getCode() {
		return code;
	}

	public ResultBean setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResultBean setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResultBean setData(Object data) {
		this.data = data;
		return this;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 成功标识
	 * 
	 * @return
	 */
	public boolean getSuccess() {
		return this.code == 0 ? true : false;
	}

}
