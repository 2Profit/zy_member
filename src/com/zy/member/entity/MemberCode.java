package com.zy.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;

/**
 * 验证码
 * @author Administrator
 *
 */
@Entity
@Table(name="mem_code")
public class MemberCode extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1708509857489104687L;

	private String mobile;			//手机号码
	
	private String code;			//验证码

	private Member member;			//注册上的用户
	
	private Integer status;			//状态 	0未使用	1使用
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name="status", precision=1)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
