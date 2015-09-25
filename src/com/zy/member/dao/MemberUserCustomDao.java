package com.zy.member.dao;

import com.zy.common.entity.PageModel;
import com.zy.member.entity.MemberUser;

public interface MemberUserCustomDao {

	PageModel<MemberUser> queryForPage(MemberUser queryDto,PageModel<MemberUser> pageModal);
}
