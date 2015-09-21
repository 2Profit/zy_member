package com.zy.member.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;

/**
 * 用户
 * @author Jeff Xu
 * @since 2015-08-18
 */
@Entity
@Table(name = "mem_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class MemberUser extends BaseEntity{

	private static final long serialVersionUID = 4489356694283694129L;

	private String userName;
	
	private String mobile;						//手机号
	
	private String email;						//邮箱
	
	private String nickName;					//昵称
	
	private String pwd;							//密码 

	private Date lastLoginDate;					//最后登录时间
	
	private String lastLoginIp;					//最后登录IP
	
	private Boolean locked;

	@Column(name = "last_login_date")
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Column(name="user_name",length=20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="pwd",length=36)
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name="locked")
	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	@Column(name = "last_login_ip", length = 64)
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="email", length=64)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="nick_name", length=128)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
