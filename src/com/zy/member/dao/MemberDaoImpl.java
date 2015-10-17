package com.zy.member.dao;

import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;
import com.zy.member.entity.Member;

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
	
	@Override
	@SuppressWarnings("unchecked")
	public PageModel<Member> queryForPage(Map<String, Object> params, Integer currentPage, Integer pageSize) {
		
		StringBuilder hql = new StringBuilder("select l from Member l where l.deleteFlag = 0 ");
		
		if(params.get("no") != null){
			hql.append(" and l.no = :no ");
		}
		
		if(params.get("cnName") != null){
			hql.append(" and l.cnName like :cnName ");
		}
		
		if(params.get("enName") != null){
			hql.append(" and l.enName like :enName ");
		}
		
		if(params.get("accountCategory") != null){
			hql.append(" and l.accountCategory = :accountCategory ");
		}

		if(params.get("accountType") != null){
			hql.append(" and l.accountType = :accountType ");
		}
		
		if(params.get("status") != null){
			hql.append(" and l.status = :status ");
		}
		
		hql.append(" order by l.no desc ");
		
		return this.queryForPageWithParams(hql.toString(), params, currentPage, pageSize);
	}
	
	public Integer getSequenceNo() {
		
		String sql = "select nextval('proposal_mem_member_no_seq')";
		BigInteger bi = this.queryCountBySql(sql, null);
		if(bi == null){
			return null;
		}
		return bi.intValue();
	}
}
