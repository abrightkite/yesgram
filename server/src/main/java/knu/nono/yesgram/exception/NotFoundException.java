package knu.nono.yesgram.exception;

public class NotFoundException extends ResponseException{
	public NotFoundException() {
		super(ErrorCode.NOT_FOUND);
	}
	
	protected NotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
}
