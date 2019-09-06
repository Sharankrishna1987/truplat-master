package com.truplat.common;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.truplat.common.exception.UserException;

@ControllerAdvice
@Order(2)
public class ErrorControllerAdvice {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> handleException(RuntimeException e) {
		return error(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
	}

	@ExceptionHandler({ UserException.class })
	public ResponseEntity<String> handleException(UserException e) {
		return error(HttpStatus.BAD_REQUEST, e.getMessage());
	}
	
	private ResponseEntity<String> error(HttpStatus status, String message) {
		// log.error("Exception : ", e);
		return ResponseEntity.status(status).body(message);
	}

}
