package knu.nono.yesgram.dto;

import knu.nono.yesgram.domain.GameBoard;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameBoardDetailResponse {
	private Long id;
	private int size;
	private List<List<Integer>> board;
	
	static public GameBoardDetailResponse fromEntity(GameBoard gameBoard) {
		String answer = gameBoard.getAnswer();
		int size = gameBoard.getSize();
		List<List<Integer>> board = new ArrayList<>();
		
		for (int i = 0; i < answer.length(); i += size) {
			List<Integer> row = new ArrayList<>();
			for(int j = i; j < i + size; j++) {
				row.add(answer.charAt(j) - '0');
			}
			board.add(row);
		}
		
		
		return new GameBoardDetailResponse(
				gameBoard.getId(),
				size,
				board
		);
	}
}
