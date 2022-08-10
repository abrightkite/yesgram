package knu.nono.yesgram.service;

import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.domain.MockUser;
import knu.nono.yesgram.repository.GameBoardRepository;
import knu.nono.yesgram.repository.MockUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameBoardService {

	private final GameBoardRepository gameBoardRepository;
	private final MockUserRepository userRepository;
	
	public Optional<GameBoard> getById(Long id) {
		return gameBoardRepository.findById(id);
	}
	
	public Page<GameBoard> getGameBoards(Optional<Integer> size, Optional<Boolean> cleared, Pageable pageable) {
		MockUser user = userRepository.getReferenceById(1L);
		
		if (cleared.isEmpty()) {
			return gameBoardRepository.findGameBoards(size, user, pageable);
		}
		else if (cleared.get()) {
			return gameBoardRepository.findClearedGameBoards(size, user, pageable);
		}
		else {
			return gameBoardRepository.findUnclearedGameBoards(size, user, pageable);
		}
	}
}
