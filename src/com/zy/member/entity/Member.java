package com.zy.member.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.zy.base.entity.Degree;
import com.zy.base.entity.Nationality;
import com.zy.broker.entity.MemBrokerRel;
import com.zy.personal.entity.MemBankInfo;

/**
 * 用户
 * @author Jeff
 * @since 2015-08-18
 */
@Entity
@Table(name = "mem_member")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Member extends MemberUser{

	private static final long serialVersionUID = 87102501953163859L;

	public static final Integer IMG_STATUS_WSC = 0;		//未上传
	public static final Integer IMG_STATUS_DSH = 1;		//待审批
	public static final Integer IMG_STATUS_TG = 2;		//有效
	public static final Integer IMG_STATUS_WTG = 3;		//未通过
	
	private Integer no;			//会员编号
	
	private Degree degree;
	private String accountType;//账号类型（全部、真实、测试）
	private String accountCategory;//账号类别（全部、客户、老师）
	private List<MemBrokerRel> memBrokerRels;//经纪商
	private MemBankInfo memBankInfo;//银行信息
	private String cnName;//中文名
	private String enName;//英文名
	private Date createAccountDate;//开户日期
	private String isBindWeChat;//wechat绑定状态（0-全部，1-绑定，2-未绑定）
	private String isVoteAuth;//投票权限（1-开，0-关）
	private String isCommentAuth;//评论权限（1-开，0-关）
	private String status;//状态（0-启用，1-冻结，2-黑名单，3-销户）

	private String headUrl;
	
	private Integer sex;		//性别 0男  1女
	private Integer cardType;	//证件类型
	private String card;		//证件号
	private String address;		//联系地址
	private Nationality nationality;	//国籍
	
	private Integer coin;		//虚拟币数量
	
	private String imgIDCardA;			//身份证正面
	private String imgIDCardB;			//身份证反面
	
	private Integer imgIDCardStatus;	//上传身份证状态		0未上传\1待审核2\有效\3审批未通过
	
	private String imgBankCard;			//银行卡证明
	
	private Integer imgBackCardStatus;	//银行卡证明状态		0未上传\1待审核2\有效\3审批未通过
	
	@Column(name="no", updatable=false)
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
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
	
	@ManyToOne(fetch=FetchType.LAZY)
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
	
	@Column(name="sex", precision=1)
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	@Column(name="card_type", precision=1)
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	
	@Column(name="card", length=128)
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	
	@Column(name="address", length=512)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nationality_id")
	public Nationality getNationality() {
		return nationality;
	}
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	
	@Column(name="img_id_card_a", length=128)
	public String getImgIDCardA() {
		return imgIDCardA;
	}
	public void setImgIDCardA(String imgIDCardA) {
		this.imgIDCardA = imgIDCardA;
	}
	
	@Column(name="img_id_card_b", length=128)
	public String getImgIDCardB() {
		return imgIDCardB;
	}
	public void setImgIDCardB(String imgIDCardB) {
		this.imgIDCardB = imgIDCardB;
	}
	
	@Column(name="img_bank_card")
	public String getImgBankCard() {
		return imgBankCard;
	}
	public void setImgBankCard(String imgBankCard) {
		this.imgBankCard = imgBankCard;
	}
	@Column(name="coin")
	public Integer getCoin() {
		return coin;
	}
	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	
	@Column(name="img_id_card_status", precision=1)
	public Integer getImgIDCardStatus() {
		return imgIDCardStatus;
	}
	public void setImgIDCardStatus(Integer imgIDCardStatus) {
		this.imgIDCardStatus = imgIDCardStatus;
	}
	
	@Column(name="img_back_card_status", precision=1)
	public Integer getImgBackCardStatus() {
		return imgBackCardStatus;
	}
	public void setImgBackCardStatus(Integer imgBackCardStatus) {
		this.imgBackCardStatus = imgBackCardStatus;
	}
	
	
	
}
