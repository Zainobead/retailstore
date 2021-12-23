package com.retail.store.discount.exception;

public class BusinessException extends Exception{

	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
