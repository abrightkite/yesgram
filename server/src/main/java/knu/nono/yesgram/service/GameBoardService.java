package knu.nono.yesgram.service;

import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.repository.GameBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameBoardService {
	
	private final GameBoardRepository gameBoardRepository;
	
	public Optional<GameBoard> getById(Long id) {
		return gameBoardRepository.findById(id);
	}
	
	public Page<GameBoard> getGameBoards(Optional<Integer> size, Optional<Boolean> cleared, Pageable pageable) {
		if (cleared.isEmpty()) {
			return gameBoardRepository.findGameBoards(size, pageable);
		}
		else if (cleared.get()) {
			return gameBoardRepository.findClearedGameBoards(size, pageable);
		}
		else {
			return gameBoardRepository.findUnclearedGameBoards(size, pageable);
		}
	}
}
