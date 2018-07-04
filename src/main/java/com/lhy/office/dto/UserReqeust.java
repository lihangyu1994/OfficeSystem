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
	/**旧密码*/
	private String oldPassword;
	/**确认新密码*/
	private String confirmPassword;
	/**用户真实姓名*/
	private String userTrueName;
	
	
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
	/**旧密码*/
	public String getOldPassword() {
		return oldPassword;
	}
	/**旧密码*/
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	/**确认新密码*/
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**确认新密码*/
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}
	
	
	
}
