package knu.nono.yesgram.controller;

import knu.nono.yesgram.dto.CreateGameRoomRequest;
import knu.nono.yesgram.service.GameRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/game_room")
@RequiredArgsConstructor
public class GameRoomController {
	
	private final GameRoomService gameRoomService;
	
	@PostMapping
	public ResponseEntity<Long> createGameRoom(@Valid @RequestBody CreateGameRoomRequest request) {
		Long gameRoomId = gameRoomService.createGameRoom(request);
		
		return ResponseEntity.ok(gameRoomId);
	}
}
