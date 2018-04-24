package cn.colg.entity;

import cn.colg.core.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 秒杀 - entity
 *
 * @author colg
 */
@Table(name = "success_killed")
public class SuccessKilled extends BaseEntity implements Serializable {
	/**
	 * 秒杀商品id
	 */
	@Id
	@Column(name = "seckill_id")
	private String seckillId;

	/**
	 * 用户手机号
	 */
	@Id
	@Column(name = "user_phone")
	private String userPhone;

	/**
	 * 状态标识（-1：无效，0：成功，1：已付款）
	 */
	@Column(name = "state")
	private String state;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 变通： 多对一
	 */
	private Seckill seckill;

	private static final long serialVersionUID = 1L;

	/**
	 * 获取秒杀商品id
	 *
	 * @return seckill_id - 秒杀商品id
	 */
	public String getSeckillId() {
		return seckillId;
	}

	/**
	 * 设置秒杀商品id
	 *
	 * @param seckillId
	 *            秒杀商品id
	 */
	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId == null ? null : seckillId.trim();
	}

	/**
	 * 获取用户手机号
	 *
	 * @return user_phone - 用户手机号
	 */
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * 设置用户手机号
	 *
	 * @param userPhone
	 *            用户手机号
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone == null ? null : userPhone.trim();
	}

	/**
	 * 获取状态标识（-1：无效，0：成功，1：已付款）
	 *
	 * @return state - 状态标识（-1：无效，0：成功，1：已付款）
	 */
	public String getState() {
		return state;
	}

	/**
	 * 设置状态标识（-1：无效，0：成功，1：已付款）
	 *
	 * @param state
	 *            状态标识（-1：无效，0：成功，1：已付款）
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_time - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

}