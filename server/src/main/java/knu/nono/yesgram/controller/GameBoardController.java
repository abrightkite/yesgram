package knu.nono.yesgram.controller;

import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.dto.GameBoardDetailResponse;
import knu.nono.yesgram.exception.NotFoundGameBoardException;
import knu.nono.yesgram.service.GameBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/game_board")
@RequiredArgsConstructor
public class GameBoardController {
	
	private final GameBoardService gameBoardService;
	
	@GetMapping("/{board_id}")
	public ResponseEntity<GameBoardDetailResponse> getById(@PathVariable("board_id") Long boardId) {
		Optional<GameBoard> gameBoardOptional = gameBoardService.getById(boardId);
		
		if (gameBoardOptional.isEmpty()) {
			throw new NotFoundGameBoardException();
		}
		
		GameBoardDetailResponse body = GameBoardDetailResponse.fromEntity(gameBoardOptional.get());
		return ResponseEntity.ok(body);
	}
}
