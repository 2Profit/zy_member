package com.zy.member.dao;

import java.util.Map;

import com.zy.common.entity.PageModel;
import com.zy.member.entity.Member;

public interface MemberDaoCustom {

	public int validUserOnly(Map<String, Object> params);
	
	PageModel<Member> queryForPage(Map<String, Object> params, Integer currentPage, Integer pageSize);
	
	public Integer getSequenceNo();
	
}
