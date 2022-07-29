package knu.nono.yesgram.controller;

import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.dto.GameBoardDetailResponse;
import knu.nono.yesgram.service.GameBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			// TODO GlobalExceptionHandler를 통해 통일된 에러형식을 생성
			return ResponseEntity.notFound().build();
		}
		
		GameBoardDetailResponse body = GameBoardDetailResponse.fromEntity(gameBoardOptional.get());
		return ResponseEntity.ok(body);
	}
}
