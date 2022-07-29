package knu.nono.yesgram.dto;

import knu.nono.yesgram.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ErrorResponse {
	private String message;
	private String code;
	
	public static ErrorResponse fromErrorCode(ErrorCode errorCode) {
		return ErrorResponse.builder()
				.code(errorCode.name())
				.message(errorCode.getMessage())
				.build();
	}
}
