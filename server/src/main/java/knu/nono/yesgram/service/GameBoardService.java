package knu.nono.yesgram.service;

import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.repository.GameBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameBoardService {
	
	private final GameBoardRepository gameBoardRepository;
	
	public Optional<GameBoard> getById(Long id) {
		return gameBoardRepository.findById(id);
	}
	
	public List<GameBoard> getGameBoards(Optional<Integer> size, Optional<Boolean> cleared) {
		if (cleared.isEmpty()) {
			return gameBoardRepository.findGameBoards(size);
		}
		else if (cleared.get()) {
			return gameBoardRepository.findClearedGameBoards(size);
		}
		else {
			return gameBoardRepository.findUnclearedGameBoards(size);
		}
	}
}
