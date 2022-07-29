package knu.nono.yesgram.service;

import knu.nono.yesgram.repository.GameRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GameRoomService {
	private final GameRoomRepository gameRoomRepository;

	public Long createGameRoom() {
		return 1L;
	}
}
