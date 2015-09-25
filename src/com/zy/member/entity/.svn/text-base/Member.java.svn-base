package com.zy.member.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zy.base.entity.Degree;

/**
 * 会员信息
 * @author Jeff
 * @since 2015-08-18
 */
@Entity
@Table(name = "mem_member")
public class Member extends MemberUser{

	private static final long serialVersionUID = 87102501953163859L;

	private Degree degree;

	@ManyToOne
	@JoinColumn(name = "degree_id")
	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	
	
}
