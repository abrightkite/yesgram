package knu.nono.yesgram.dto;

import knu.nono.yesgram.domain.GameBoard;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameBoardDetailResponse {
	private Long id;
	private int size;
	private String board;
	
	static public GameBoardDetailResponse fromEntity(GameBoard gameBoard) {
		return new GameBoardDetailResponse(
				gameBoard.getId(),
				gameBoard.getSize(),
				gameBoard.getAnswer()
		);
	}
}
