package com.goapps.midday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfiguration {

	/*
	 * @ExceptionHandler(value = InvalidRequestException.class) public
	 * ResponseEntity<?> invalidRequestExceptionProcessing(InvalidRequestException
	 * ex) { return new ResponseEntity<>(ex.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	@ExceptionHandler(value = GenericException.class)
	public ResponseEntity<?> exception(GenericException ex) {
	      return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
}
