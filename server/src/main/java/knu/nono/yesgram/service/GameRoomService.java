package knu.nono.yesgram.service;

import knu.nono.yesgram.domain.GameRoom;
import knu.nono.yesgram.domain.MockUser;
import knu.nono.yesgram.dto.CreateGameRoomRequest;
import knu.nono.yesgram.repository.GameRoomRepository;
import knu.nono.yesgram.repository.MockUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class GameRoomService {
	private final GameRoomRepository gameRoomRepository;
	private final MockUserRepository userRepository;

	@Transactional
	public Long createGameRoom(CreateGameRoomRequest request) {
		MockUser user = userRepository.getReferenceById(1L);
		
		GameRoom gameRoom = request.toEntity();
		
		gameRoom.createAndSetUUIDCode();
		gameRoom.setCreatedUser(user);
		
		gameRoomRepository.save(gameRoom);
		
		return gameRoom.getId();
	}
}
