package knu.nono.yesgram.controller;

import knu.nono.yesgram.dto.ErrorResponse;
import knu.nono.yesgram.exception.ErrorCode;
import knu.nono.yesgram.exception.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResponseException.class)
	public ResponseEntity<ErrorResponse> handleCommonException(ResponseException ex) {
		ErrorCode errorCode = ex.getErrorCode();
		
		log.error("handleCommonException : {}", errorCode);
		ErrorResponse body = ErrorResponse.fromErrorCode(errorCode);
		
		return ResponseEntity.status(errorCode.getHttpStatus()).body(body);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorCode errorCode = ErrorCode.NOT_FOUND;

		log.error("handleNoHandlerFoundException : {}", errorCode);
		ErrorResponse body = ErrorResponse.fromErrorCode(errorCode);

		return ResponseEntity.status(errorCode.getHttpStatus()).body(body);
	}
}
