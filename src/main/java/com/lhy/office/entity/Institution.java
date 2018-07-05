package com.lhy.office.entity;


/**
 * 组织机构
 * @author Administrator
 *
 */
public class Institution {
	
	private Integer instId;
	
	private Integer mergedinstId;
	
	private String instName;
	
	private String instAddr;
	
	private String postCode;
	
	private Integer instState;
	
   private Institution mergedInstitution;

	public Integer getInstId() {
		return instId;
	}

	public void setInstId(Integer instId) {
		this.instId = instId;
	}

	public Integer getMergedinstId() {
		return mergedinstId;
	}

	public void setMergedinstId(Integer mergedinstId) {
		this.mergedinstId = mergedinstId;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getInstAddr() {
		return instAddr;
	}

	public void setInstAddr(String instAddr) {
		this.instAddr = instAddr;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Integer getInstState() {
		return instState;
	}

	public void setInstState(Integer instState) {
		this.instState = instState;
	}

	public Institution getMergedInstitution() {
		return mergedInstitution;
	}

	public void setMergedInstitution(Institution mergedInstitution) {
		this.mergedInstitution = mergedInstitution;
	}

}
