package cn.colg.dto;

import cn.colg.core.BaseEntity;
import cn.colg.entity.SuccessKilled;
import cn.colg.enums.ExceptionEnum;

/**
 * 封装秒杀执行后的结果
 *
 * @author colg
 */
public class SeckillExecution extends BaseEntity {

	/**
	 * 库存商品id
	 */
	private String seckillId;

	/**
	 * 商品秒杀状态标识（-1：无效，0：成功，1：已付款）
	 */
	private Integer state;

	/**
	 * 状态表示
	 */
	private String stateInfo;

	/**
	 * 秒杀成功对象，当秒杀成功时，返回此对象
	 */
	private SuccessKilled successKilled;

	public SeckillExecution() {
	}
	
	public SeckillExecution(String seckillId, ExceptionEnum exceptionEnum) {
		this.seckillId = seckillId;
		this.state = exceptionEnum.getCode();
		this.stateInfo = exceptionEnum.getMsg();
	}

	public SeckillExecution(String seckillId, ExceptionEnum exceptionEnum, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.state = exceptionEnum.getCode();
		this.stateInfo = exceptionEnum.getMsg();
		this.successKilled = successKilled;
	}

	public String getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

}
