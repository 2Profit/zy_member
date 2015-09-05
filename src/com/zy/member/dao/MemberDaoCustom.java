package com.zy.member.dao;

import com.zy.common.entity.PageModel;
import com.zy.member.entity.Member;

public interface MemberDaoCustom {

	PageModel<Member> queryForPage(Member queryDto,PageModel<Member> pageModal);
}
