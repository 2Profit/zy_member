package com.zy.member.dao;

import java.util.Map;
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
	public PageModel<Member> queryForPage(Member queryDto, PageModel<Member> pageModal) {
		StringBuilder hql = new StringBuilder("select l from Member l where 1=1 ");
		Map<String,Object> params = new HashMap<String,Object>();
		
		if(StringUtils.isNotBlank(queryDto.getId())){
			hql.append(" and l.id = :memberId ");
			params.put("memberId", queryDto.getId());
		}
		if(StringUtils.isNotBlank(queryDto.getUserName())){
			hql.append(" and l.userName like :userName ");
			params.put("userName", "%"+queryDto.getUserName()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getCnName())){
			hql.append(" and l.cnName like :cnName ");
			params.put("cnName", "%"+queryDto.getCnName()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getEnName())){
			hql.append(" and l.enName like :enName ");
			params.put("enName", "%"+queryDto.getEnName()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getCellphone())){
			hql.append(" and l.cellphone like :cellphone ");
			params.put("cellphone", "%"+queryDto.getCellphone()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getTelephone())){
			hql.append(" and l.telephone like :telephone ");
			params.put("telephone", "%"+queryDto.getTelephone()+"%");
		}
		if(StringUtils.isNotBlank(queryDto.getAccountCategory())){
			hql.append(" and l.accountCategory = :accountCategory ");
			params.put("accountCategory", queryDto.getAccountCategory());
		}
		hql.append(" order by l.updateDate desc ");
		
		return this.queryForPageWithParams(hql.toString(),params,pageModal.getCurrentPage(), pageModal.getPageSize());
	}
}
