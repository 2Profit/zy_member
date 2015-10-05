package com.zy.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.service.CommonService;
import com.zy.member.dao.MemberCodeDao;
import com.zy.member.entity.MemberCode;

@Service
public class MemberCodeService extends CommonService<MemberCode, String> {

	@Autowired
	private MemberCodeDao memberCodeDao;
	
	@Autowired
	public void setMemberCodeDao(MemberCodeDao memberCodeDao){
		super.setCommonDao(memberCodeDao);
	}
	
	public List<MemberCode> findCodesByMobile(String mobile){
		return memberCodeDao.findCodesByMobile(mobile);
	}
	
}
