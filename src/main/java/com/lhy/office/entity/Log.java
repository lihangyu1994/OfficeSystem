package com.lhy.office.entity;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer logId;

	private String optName;

	private Integer bussinessId;

	private Integer operatorId;

	private String ipAddress;

	private Date optTime;

	private User operator;

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public Integer getBussinessId() {
		return bussinessId;
	}

	public void setBussinessId(Integer bussinessId) {
		this.bussinessId = bussinessId;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

}
