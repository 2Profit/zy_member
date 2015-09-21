package com.zy.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.service.CommonService;
import com.zy.member.dao.MemberUserDao;
import com.zy.member.entity.MemberUser;

@Service
public class MemberUserService extends CommonService<MemberUser,String>{

	@Autowired
	private MemberUserDao memberUserDao;

	@Autowired
	public void setMemberUserDao(MemberUserDao memberUserDao) {
		super.setCommonDao(memberUserDao);
	}

}
