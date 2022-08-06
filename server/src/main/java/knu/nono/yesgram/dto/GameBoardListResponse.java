package knu.nono.yesgram.dto;

import knu.nono.yesgram.domain.GameBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameBoardListResponse {
	
	private List<GameBoardDto> boards;

	static public GameBoardListResponse fromEntities(List<GameBoard> gameBoards) {
		List<GameBoardDto> boards = gameBoards
				.stream()
				.map(GameBoardDto::fromEntity)
				.collect(Collectors.toList());
		
		return new GameBoardListResponse(boards);
	}
}


