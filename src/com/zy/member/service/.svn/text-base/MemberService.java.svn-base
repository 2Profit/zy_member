package com.zy.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.service.CommonService;
import com.zy.member.dao.MemberDao;
import com.zy.member.entity.Member;

@Service
public class MemberService extends CommonService<Member,String>{

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		super.setCommonDao(memberDao);
	}
	
}
