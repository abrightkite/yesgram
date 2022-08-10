package knu.nono.yesgram.dto;

import knu.nono.yesgram.domain.GameBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameBoardListResponse {
	
	private List<GameBoardDto> boards;

	static public GameBoardListResponse fromEntities(Page<GameBoard> gameBoards) {
		List<GameBoardDto> boards = gameBoards
				.stream()
				.map(GameBoardDto::fromEntity)
				.collect(Collectors.toList());
		
		boards.forEach(GameBoardDto::maskBoardIfNotCleared);
		
		return new GameBoardListResponse(boards);
	}
}


