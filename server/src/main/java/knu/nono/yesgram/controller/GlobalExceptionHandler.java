package knu.nono.yesgram.controller;

import knu.nono.yesgram.dto.ErrorResponse;
import knu.nono.yesgram.exception.ErrorCode;
import knu.nono.yesgram.exception.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResponseException.class)
	public ResponseEntity<ErrorResponse> handleCommonException(ResponseException ex, WebRequest request) {
		ErrorCode errorCode = ex.getErrorCode();

		log.error("{} : {}", getRequestPath(request), errorCode);
		ErrorResponse body = ErrorResponse.fromErrorCode(errorCode);
		
		return ResponseEntity.status(errorCode.getHttpStatus()).body(body);
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex, WebRequest request) {
		ErrorCode errorCode = ErrorCode.INVALID_PARAM;
		
		log.error("{} : {}", getRequestPath(request), ex.getMessage());
		ErrorResponse body = ErrorResponse.fromErrorCode(errorCode);

		return ResponseEntity.status(errorCode.getHttpStatus()).body(body);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorCode errorCode = ErrorCode.INVALID_PARAM;

		List<String> errors = ex.getBindingResult().getFieldErrors()
				.stream()
				.map(e -> String.format("field: %s, message: %s", e.getField(), e.getDefaultMessage()))
				.collect(Collectors.toList());
		
		log.error("{} : {}", getRequestPath(request), errors);
		ErrorResponse body = ErrorResponse.fromErrorCode(errorCode);

		return ResponseEntity.status(errorCode.getHttpStatus()).body(body);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorCode errorCode = ErrorCode.INVALID_PARAM;
		
		log.error("{} : {}", getRequestPath(request), ex.getMessage());
		ErrorResponse body = ErrorResponse.fromErrorCode(errorCode);

		return ResponseEntity.status(errorCode.getHttpStatus()).body(body);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorCode errorCode = ErrorCode.MISSING_PARAM;

		log.error("{} : {}", getRequestPath(request), ex.getMessage());
		ErrorResponse body = ErrorResponse.fromErrorCode(errorCode);

		return ResponseEntity.status(errorCode.getHttpStatus()).body(body);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorCode errorCode = ErrorCode.INVALID_PARAM;

		log.error("{} : {}", getRequestPath(request), ex.getMessage());
		ErrorResponse body = ErrorResponse.fromErrorCode(errorCode);

		return ResponseEntity.status(errorCode.getHttpStatus()).body(body);
	}

	private String getRequestPath(WebRequest request) {
		return ((ServletWebRequest) request).getRequest().getRequestURI();
	}
}
