package com.zy.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;
import com.zy.member.entity.MemberUser;

public class MemberUserDaoImpl extends CustomBaseSqlDaoImpl implements MemberUserCustomDao{

	@Override
	@SuppressWarnings("unchecked")
	public PageModel<MemberUser> queryForPage(MemberUser queryDto, PageModel<MemberUser> pageModal) {
		StringBuilder hql = new StringBuilder("select l from MemberUser l where 1=1 ");
		Map<String,Object> params = new HashMap<String,Object>();
		
		if(StringUtils.isNotBlank(queryDto.getUserName())){
			hql.append(" and l.userName like :userName ");
			params.put("userName", "%"+queryDto.getUserName()+"%");
		}
		hql.append(" order by l.updateDate desc ");
		
		return this.queryForPageWithParams(hql.toString(),params,pageModal.getCurrentPage(), pageModal.getPageSize());
	}
}
