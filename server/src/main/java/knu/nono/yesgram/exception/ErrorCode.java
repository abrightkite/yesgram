package knu.nono.yesgram.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@ToString
public enum ErrorCode {
	/* 400 BAD_REQUEST */
	INVALID_PARAM(HttpStatus.BAD_REQUEST, "유효하지 않은 파라미터입니다."),
	MISSING_PARAM(HttpStatus.BAD_REQUEST, "필수 파라미터가 누락되었습니다."),

	/* 404 NOT_FOUND */
	NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found"),
	NOT_FOUND_GAME_BOARD(HttpStatus.NOT_FOUND, "해당 게임판을 찾을 수 없습니다."),

	/* 5xx INTER_SERVER_ERROR */
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error")
	;


	private final HttpStatus httpStatus;
	private final String message;
}