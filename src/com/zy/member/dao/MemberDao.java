package com.zy.member.dao;

import com.zy.common.dao.CommonDao;
import com.zy.member.entity.Member;

public interface MemberDao extends MemberDaoCustom,CommonDao<Member,String>{

}