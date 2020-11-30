package com.kr.connected.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class EntityExceptionHandler  extends ResponseEntityExceptionHandler {

	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<Object> handleIllegalArgumentException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(String.format("Bad Request: %s", ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}
