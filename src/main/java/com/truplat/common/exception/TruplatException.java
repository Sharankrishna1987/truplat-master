package com.truplat.common.exception;

public class TruplatException extends RuntimeException {

	private static final long serialVersionUID = 5151530543686685071L;

	private String message;

	public TruplatException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
