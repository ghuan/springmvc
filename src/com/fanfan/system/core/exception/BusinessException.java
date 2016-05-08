package com.fanfan.system.core.exception;

import com.fanfan.system.util.constants.System_Constants;

/**
 * 
* Copy right huan.gao 2015-7-13下午06:48:44
* All right reserved
* QQ:2223486623 
* description：自定义异常类JSON
 */
public class BusinessException extends RuntimeException {  
	  
    private static final long serialVersionUID = 1L;  
  
    /**
	* @Fields type : 异常类型
	*/
	private int type = Integer.parseInt(System_Constants.EXCEPTION_TYPE_COMMON);//0普通异常,1会话过期
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param msg
	*/
	public BusinessException(String msg) {
		super(msg);
	}
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param msg
	* @param type
	*/
	public BusinessException(String msg, int type) {
		super(msg);
		this.type = type;
	}
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param msg
	* @param des
	*/
	public BusinessException(String msg, String des) {
		super(msg, new Throwable(des));
	}
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param msg
	* @param des
	* @param type
	*/
	public BusinessException(String msg, String des, int type) {
		super(msg, new Throwable(des));
		this.type = type;
	}
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param msg
	* @param t
	*/
	public BusinessException(String msg, Throwable t) {
		super(msg, t);
	}
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param msg
	* @param t
	* @param type
	*/
	public BusinessException(String msg, Throwable t, int type) {
		super(msg, t);
		this.type = type;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
  
}

