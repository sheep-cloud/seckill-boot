package cn.colg.enums;

/**
 * 使用枚举表述常量数据字段
 *
 * @author colg
 */
public enum ExceptionEnum {
	
	// 枚举类必须定义枚举值，编译才会通过
	
	UNKNOW_ERROR 	(500,	"未知错误"),
	SUCCESS			(1, 	"秒杀成功"),
	END				(0, 	"秒杀结束"),
	REPEAT_KILL		(-1, 	"重复秒杀"),
	INNER_ERROR		(-2,	"系统异常"),
	DATA_REWRITE	(-3,	"数据篡改");
	
	private Integer code;
	private String msg;
	
	ExceptionEnum(Integer code, String msg) {
	      this.code = code;
	      this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
	
}
