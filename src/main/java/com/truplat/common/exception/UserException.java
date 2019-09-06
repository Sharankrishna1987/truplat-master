package com.truplat.common.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 8633927309123459226L;
	
	private String message;

	public UserException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
