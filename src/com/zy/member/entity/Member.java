package com.zy.member.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.zy.base.entity.Degree;
import com.zy.broker.entity.MemBrokerRel;
import com.zy.personal.entity.MemBankInfo;

/**
 * ��Ա��Ϣ
 * @author Jeff
 * @since 2015-08-18
 */
@Entity
@Table(name = "mem_member")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Member extends MemberUser{

	private static final long serialVersionUID = 87102501953163859L;

	private Degree degree;
	private String accountType;//账号类型（全部、真实、测试）
	private String accountCategory;//账号类别（全部、客户、老师）
	private List<MemBrokerRel> memBrokerRels;//经纪商
	private MemBankInfo memBankInfo;//银行信息
	private String cnName;//中文名
	private String enName;//英文名
	private String telephone;//电话
	private String cellphone;//手机
	private Date createAccountDate;//开户日期
	private String isBindWeChat;//wechat绑定状态（0-全部，1-绑定，2-未绑定）
	private String isVoteAuth;//投票权限（1-开，0-关）
	private String isCommentAuth;//评论权限（1-开，0-关）
	private String status;//状态（0-启用，1-冻结，2-黑名单，3-销户）

	private String headUrl;
	
	@ManyToOne
	@JoinColumn(name = "degree_id")
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	@Column(length=2)
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Column(length=2)
	public String getAccountCategory() {
		return accountCategory;
	}
	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "member")
	public List<MemBrokerRel> getMemBrokerRels() {
		return memBrokerRels;
	}
	public void setMemBrokerRels(List<MemBrokerRel> memBrokerRels) {
		this.memBrokerRels = memBrokerRels;
	}
	
	@JoinColumn(name = "mem_bank_info_id")
	public MemBankInfo getMemBankInfo() {
		return memBankInfo;
	}
	public void setMemBankInfo(MemBankInfo memBankInfo) {
		this.memBankInfo = memBankInfo;
	}
	@Column(length=64)
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	@Column(length=64)
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	@Column(length=16)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(length=16)
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Date getCreateAccountDate() {
		return createAccountDate;
	}
	public void setCreateAccountDate(Date createAccountDate) {
		this.createAccountDate = createAccountDate;
	}
	@Column(length=2)
	public String getIsBindWeChat() {
		return isBindWeChat;
	}
	public void setIsBindWeChat(String isBindWeChat) {
		this.isBindWeChat = isBindWeChat;
	}
	@Column(length=2)
	public String getIsVoteAuth() {
		return isVoteAuth;
	}
	public void setIsVoteAuth(String isVoteAuth) {
		this.isVoteAuth = isVoteAuth;
	}
	@Column(length=2)
	public String getIsCommentAuth() {
		return isCommentAuth;
	}
	public void setIsCommentAuth(String isCommentAuth) {
		this.isCommentAuth = isCommentAuth;
	}
	@Column(length=2)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="head_url", length=256)
	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	
}
