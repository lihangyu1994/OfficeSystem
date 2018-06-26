package com.lhy.office.entity;
/**
 * 组织机构
 * @author Administrator
 *
 */
public class Institution {
	
	private int instId;
	
	private int mergedinstId;
	
	private String instName;
	
	private String instAddr;
	
	private String postCode;
	
	private int instState;

	public int getInstId() {
		return instId;
	}

	public void setInstId(int instId) {
		this.instId = instId;
	}

	public int getMergedinstId() {
		return mergedinstId;
	}

	public void setMergedinstId(int mergedinstId) {
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

	public int getInstState() {
		return instState;
	}

	public void setInstState(int instState) {
		this.instState = instState;
	}
	
	
}
