package knu.nono.yesgram.service;

import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.repository.GameBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameBoardService {
	
	private final GameBoardRepository gameBoardRepository;
	
	public Optional<GameBoard> getById(Long id) {
		return gameBoardRepository.findById(id);
	}
	
}
