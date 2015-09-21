package com.zy.member.dao;

import java.util.Map;

import com.zy.common.dao.CustomBaseSqlDaoImpl;

public class MemberDaoImpl extends CustomBaseSqlDaoImpl implements MemberDaoCustom{

	@Override
	public int validUserOnly(Map<String, Object> params) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*) from MemberUser u where u.deleteFlag = 0 ");
		
		Object mobile = params.get("mobile");
		if(mobile != null){
			sb.append(" and u.mobile = :mobile ");
		}
		
		Object email = params.get("email");
		if(email != null){
			sb.append(" and u.email = :email ");
		}
		
		Object nickName = params.get("nickName");
		if(nickName != null){
			sb.append(" and u.nickName = :nickName ");
		}
		
		return this.queryCount(sb.toString(), params).intValue();
	}

}
