package knu.nono.yesgram.controller;

import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.dto.GameBoardDto;
import knu.nono.yesgram.dto.GameBoardListResponse;
import knu.nono.yesgram.exception.NotFoundGameBoardException;
import knu.nono.yesgram.service.GameBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game_board")
@RequiredArgsConstructor
public class GameBoardController {
	
	private final GameBoardService gameBoardService;
	
	@GetMapping("/{board_id}")
	public ResponseEntity<GameBoardDto> getById(@PathVariable("board_id") Long boardId) {
		Optional<GameBoard> gameBoardOptional = gameBoardService.getById(boardId);
		
		if (gameBoardOptional.isEmpty()) {
			throw new NotFoundGameBoardException();
		}
		
		GameBoardDto body = GameBoardDto.fromEntity(gameBoardOptional.get());
		return ResponseEntity.ok(body);
	}
	
	@GetMapping
	public ResponseEntity<GameBoardListResponse> getGameBoards() {
		List<GameBoard> gameBoards = gameBoardService.getGameBoards();
		
		GameBoardListResponse body = GameBoardListResponse.fromEntities(gameBoards);
		return ResponseEntity.ok(body);
	}
}
