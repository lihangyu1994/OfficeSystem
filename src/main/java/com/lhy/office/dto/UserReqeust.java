package com.lhy.office.dto;

import com.lhy.office.dto.base.BaseResponse;
/**
 * 客户信息
 * @author Administrator
 *
 */
public class UserReqeust extends BaseResponse{
	/**登录用户名*/
	private String loginName;
	/**密码*/
	private String password;
	/**验证码*/
	private String code;
	
	
	/**登录用户名*/
	public String getLoginName() {
		return loginName;
	}
	/**登录用户名*/
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**密码*/
	public String getPassword() {
		return password;
	}
	/**密码*/
	public void setPassword(String password) {
		this.password = password;
	}
	/**验证码*/
	public String getCode() {
		return code;
	}
	/**验证码*/
	public void setCode(String code) {
		this.code = code;
	}
	
	
}