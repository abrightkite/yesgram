package knu.nono.yesgram.controller;

import knu.nono.yesgram.dto.ErrorResponse;
import knu.nono.yesgram.exception.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResponseException.class)
	public ResponseEntity<ErrorResponse> handleCommonException(ResponseException ex) {
		log.error("handleCommonException : {}", ex.getErrorCode());
		return ErrorResponse.fromErrorCode(ex.getErrorCode());
	}
}
