package com.fanfan.system.core.hibernate;

/**
 * 
 * Copy right huan.gao 下午9:46:14 All right reserved QQ:2223486623
 * description：分页类
 */
public class Page {
	private int totalProperty;
	private int start;
	private int limit;
	private Object data;
	public int getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
