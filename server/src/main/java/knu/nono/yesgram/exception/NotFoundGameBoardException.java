package knu.nono.yesgram.exception;

public class NotFoundGameBoardException extends NotFoundException {
	public NotFoundGameBoardException() {
		super(ErrorCode.NOT_FOUND_GAME_BOARD);
	}
}
