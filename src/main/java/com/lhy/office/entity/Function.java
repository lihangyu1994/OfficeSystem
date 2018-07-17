package com.lhy.office.entity;

/**
 * 系统功能
 * @author Administrator
 *
 */
public class Function {

	/**功能id*/
	private Integer funId;
	/**功能名称*/
	private String funName;
	/**功能url*/
	private String funUrl;
	/**父功能id*/
	private Integer funPid;
	/**父功能信息(数据库不对应表字段，靠级联查询)*/
	private Function parentFunction;
	/**功能状态:0禁用，1正常*/
	private Integer funState;

	/**功能id*/
	public Integer getFunId() {
		return funId;
	}

	/**功能id*/
	public void setFunId(Integer funId) {
		this.funId = funId;
	}

	/**功能名称*/
	public String getFunName() {
		return funName;
	}

	/**功能名称*/
	public void setFunName(String funName) {
		this.funName = funName;
	}

	/**功能url*/
	public String getFunUrl() {
		return funUrl;
	}

	/**功能url*/
	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}

	/**父功能id*/
	public Integer getFunPid() {
		return funPid;
	}

	/**父功能id*/
	public void setFunPid(Integer funPid) {
		this.funPid = funPid;
	}

	/**父功能信息(数据库不对应表字段，靠级联查询)*/
	public Function getParentFunction() {
		return parentFunction;
	}

	/**父功能信息(数据库不对应表字段，靠级联查询)*/
	public void setParentFunction(Function parentFunction) {
		this.parentFunction = parentFunction;
	}

	/**功能状态:0禁用，1正常*/
	public Integer getFunState() {
		return funState;
	}

	/**功能状态:0禁用，1正常*/
	public void setFunState(Integer funState) {
		this.funState = funState;
	}

}
