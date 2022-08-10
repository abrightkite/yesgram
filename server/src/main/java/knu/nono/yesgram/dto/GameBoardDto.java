package knu.nono.yesgram.dto;

import knu.nono.yesgram.domain.GameBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameBoardDto {
	private Long id;
	private int size;
	private List<List<Integer>> board;
	private boolean cleared;
	
	public void maskBoardIfNotCleared() {
		if (!cleared) {
			board = null;
		}
	}
	
	static public GameBoardDto fromEntity(GameBoard gameBoard) {
		String answer = gameBoard.getAnswer();
		int size = gameBoard.getSize();
		List<List<Integer>> board = parseBoard(answer, size);
		boolean cleared = !gameBoard.getClearedUsers().isEmpty();
		
		return new GameBoardDto(
				gameBoard.getId(),
				size,
				board,
				cleared
		);
	}
	
	static private List<List<Integer>> parseBoard(String answer, int size) {
		List<List<Integer>> board = new ArrayList<>();
		
		for (int i = 0; i < answer.length(); i += size) {
			List<Integer> row = new ArrayList<>();
			for(int j = i; j < i + size; j++) {
				row.add(answer.charAt(j) - '0');
			}
			board.add(row);
		}
		
		return board;
	}
}
