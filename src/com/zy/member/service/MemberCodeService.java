package com.zy.member.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.service.CommonService;
import com.zy.common.util.DateUtils;
import com.zy.member.dao.MemberCodeDao;
import com.zy.member.entity.MemberCode;

@Service
public class MemberCodeService extends CommonService<MemberCode, String> {

	@Autowired
	private MemberCodeDao memberCodeDao;
	
	@Autowired
	public void setMemberCodeDao(MemberCodeDao memberCodeDao){
		super.setCommonDao(memberCodeDao);
	}
	
	public List<MemberCode> findCodesByMobile(String mobile){
		return memberCodeDao.findCodesByMobile(mobile);
	}
	
	/**
	 * 短信验证码验证
	 * @param mobile
	 * @param code
	 * @param SMSVaildTimeInt
	 * @return
	 */
	public Map<String, Object> validatorCode(String mobile, String code, int SMSVaildTimeInt){
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = "";
		List<MemberCode> memberCodes = findCodesByMobile(mobile);
		MemberCode memberCode = null;
		if(memberCodes == null || memberCodes.isEmpty()){
			msg = "短信验证码错误";
		}else{
			
			memberCode = memberCodes.get(0);
			Date currentDate = new Date();
			
			if(DateUtils.addMinutes(memberCode.getCreateDate(), SMSVaildTimeInt).before(currentDate)){
				msg = "短信验证码已过期，请重新操作";
			}else{
				code = StringUtils.trimToEmpty(code);
				if(!code.equals(memberCode.getCode())){
					msg = "短信验证码错误";
				}
			}
			map.put("memberCode", memberCode);
		}
		map.put("msg", msg);
		return map;
	}
	
}
