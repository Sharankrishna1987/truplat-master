package com.truplat.common;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//  @ExceptionHandler(StudentNotFoundException)
//  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(StudentNotFoundException ex, WebRequest request) {
//    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
//        request.getDescription(false));
//    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//  }
  
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
	  
	  return new ResponseEntity<Object>(ex.getBindingResult().getAllErrors().stream().collect(
              Collectors.toMap(objectError -> objectError.getCodes()[1] , objectError -> objectError.getDefaultMessage())), HttpStatus.BAD_REQUEST);
  } 
  
  
	@ExceptionHandler(ConstraintViolationException.class)
	@Nullable
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
		
		Map<String, String> map = new HashMap<>();
		map.put("error.officialEmailAddress.duplicate", ex.getConstraintName());
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

  
  
  
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ExceptionHandler(MethodArgumentNotValidException.class)
//  public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//      return ex.getBindingResult()
//          .getAllErrors().stream()
//          .map(ObjectError::getDefaultMessage)
//          .collect(Collectors.toList());
//  }
  
}
