package com.zy.member.dao;

import org.springframework.data.jpa.repository.Query;

import com.zy.common.dao.CommonDao;
import com.zy.member.entity.Member;

public interface MemberDao extends MemberDaoCustom,CommonDao<Member,String>{
	
	@Query("from Member m where m.deleteFlag = 0 and (m.mobile = ?1 or m.email = ?1) ")
	public Member findMemberByLogin(String username);
	
}
