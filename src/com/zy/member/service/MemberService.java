package com.zy.member.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.member.dao.MemberDao;
import com.zy.member.entity.Member;
import com.zy.member.entity.MemberCode;
import com.zy.personal.entity.MemBankInfo;
import com.zy.personal.service.MemBankInfoService;

@Service
public class MemberService extends CommonService<Member,String>{

	@Autowired
	private MemberCodeService memberCodeService;
	
	@Autowired
	private MemBankInfoService memBankInfoService;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		super.setCommonDao(memberDao);
	}
	
	public PageModel<Member> queryForPage(Member queryDto,PageModel<Member> pageModal){
		return memberDao.queryForPage(queryDto, pageModal);
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
	
	public void saveMember(Member member, MemberCode memberCode){
		
		memberDao.save(member);
		
		memberCode.setMember(member);
		memberCode.setStatus(1);
		memberCodeService.save(memberCode);
	}
	
	public void saveOrUpdateMember(Member member, MemBankInfo memBankInfo){
		
		if(StringUtils.isNotBlank(memBankInfo.getId())){
			memBankInfoService.update(memBankInfo);
		}else{
			memBankInfoService.save(memBankInfo);
		}
		
		memberDao.save(member);
		
	}
}
