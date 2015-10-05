package com.zy.member.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.zy.common.dao.CommonDao;
import com.zy.member.entity.MemberCode;


public interface MemberCodeDao extends CommonDao<MemberCode, String> {

	@Query("from MemberCode c where c.deleteFlag = 0 and c.mobile = ?1 order by c.createDate desc")
	public List<MemberCode> findCodesByMobile(String mobile);
	
}
