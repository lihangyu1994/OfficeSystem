package com.lhy.office.dto.base;

import java.io.Serializable;

/**
 * 请求基类
 * @author Administrator
 *
 */
public class BaseResponse implements Serializable {

	private long firstResult;

	// 初始值  每页显示默认10条记录
	private long maxResult = 10;

	public long getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(long firstResult) {
		this.firstResult = firstResult;
	}

	public long getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(long maxResult) {
		this.maxResult = maxResult;
	}
}
