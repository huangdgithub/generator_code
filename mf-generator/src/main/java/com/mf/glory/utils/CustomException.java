package com.mf.glory.utils;

/**
 * 异常处理器
 * @Author: Ethan huang
 * @CreateDate: 2019/3/29 11:45
 */
public class CustomException extends RuntimeException {

    private String msg;
    private int code = 500;
    
    public CustomException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public CustomException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public CustomException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
