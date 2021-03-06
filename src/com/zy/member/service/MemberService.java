package com.zy.member.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.broker.entity.MemBrokerRel;
import com.zy.broker.service.MemBrokerRelService;
import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.member.dao.MemberDao;
import com.zy.member.entity.Member;
import com.zy.member.entity.MemberCode;
import com.zy.personal.entity.MemBankInfo;
import com.zy.personal.service.MemBankInfoService;
import com.zy.proposal.entity.ProposalBackDiscount;
import com.zy.proposal.service.ProposalBackDiscountService;

@Service
public class MemberService extends CommonService<Member,String>{

	@Autowired
	private MemberCodeService memberCodeService;
	
	@Autowired
	private MemBankInfoService memBankInfoService;
	
	@Autowired
	private MemBrokerRelService memBrokerRelService;
	
	@Autowired
	private ProposalBackDiscountService proposalBackDiscountService;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		super.setCommonDao(memberDao);
	}
	
	public PageModel<Member> queryForPage(Map<String, Object> params, Integer currentPage, Integer pageSize) {
		return memberDao.queryForPage(params, currentPage, pageSize);
	}
	
	public int validUserOnly(Map<String, Object> params){
		return memberDao.validUserOnly(params);
	}
	
	public int vaildUserByMobile(String mobile){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobile", mobile);
		return validUserOnly(params);
	}
	
	public int vaildUserByEmail(String email){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		return validUserOnly(params);
	}
	
	public int vaildUserByNickName(String nickName){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nickName", nickName);
		return validUserOnly(params);
	}
	
	public Member findMemberByLogin(String username){
		return memberDao.findMemberByLogin(username);
	}
	
	public Member findMemberByNo(Integer no){
		return memberDao.findMemberByNo(no);
	}
	
	public void saveMember(Member member, MemberCode memberCode, ProposalBackDiscount proposalBackDiscount){
		
		if(proposalBackDiscount != null){
			MemBankInfo memBankInfo = new MemBankInfo();
			memBankInfo.setBankAccount(proposalBackDiscount.getBankName());
			memBankInfo.setBankCardNum(proposalBackDiscount.getBankCard());
			memBankInfo.setBankAddress(proposalBackDiscount.getName());
			memBankInfoService.save(memBankInfo);
			
			member.setMemBankInfo(memBankInfo);
			
			member.setEmail(proposalBackDiscount.getEmail());
		}
		
		memberDao.save(member);
		
		memberCode.setMember(member);
		memberCode.setStatus(1);
		memberCodeService.save(memberCode);
		
		if(proposalBackDiscount != null){
			//用户与经纪商关系
			MemBrokerRel memBrokerRel = new MemBrokerRel();
			memBrokerRel.setBrokerInfo(proposalBackDiscount.getBrokerInfo());
			memBrokerRel.setMember(member);
			memBrokerRel.setMt4Card(proposalBackDiscount.getMt4Card());
			memBrokerRelService.save(memBrokerRel);
			
			proposalBackDiscount.setRegisterStatus(1);
			proposalBackDiscount.setMember(member);
			proposalBackDiscountService.update(proposalBackDiscount);
		}
		
	}
	
	public void saveOrUpdateMember(Member member, MemBankInfo memBankInfo){
		
		if(StringUtils.isNotBlank(memBankInfo.getId())){
			memBankInfoService.update(memBankInfo);
		}else{
			memBankInfoService.save(memBankInfo);
		}
		
		memberDao.save(member);
		
	}
	
//	public Integer getSequenceNo() {
//		return memberDao.getSequenceNo();
//	}
	
	public Member findMemberByEmail(String email) {
		return memberDao.findMemberByEmail(email);
	}
	
}
