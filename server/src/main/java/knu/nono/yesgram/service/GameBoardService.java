package knu.nono.yesgram.service;

import knu.nono.yesgram.domain.ClearedGameBoard;
import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.domain.MockUser;
import knu.nono.yesgram.repository.ClearedGameBoardRepository;
import knu.nono.yesgram.repository.GameBoardRepository;
import knu.nono.yesgram.repository.MockUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameBoardService {

	private final ClearedGameBoardRepository cgbRepository;
	private final GameBoardRepository gameBoardRepository;
	private final MockUserRepository userRepository;
	
	public Optional<GameBoard> getById(Long id) {
		return gameBoardRepository.findById(id);
	}
	
	public Page<GameBoard> getGameBoards(Optional<Integer> size, Optional<Boolean> cleared, Pageable pageable) {
		MockUser user = userRepository.getReferenceById(1L);
		
		Page<GameBoard> result;
 		if (cleared.isEmpty()) {
			result = gameBoardRepository.findGameBoards(size, pageable);
			List<GameBoard> clearedGameBoards = 
					cgbRepository
							.findAllByUserAndGameBoardIsIn(user, result.toList())
							.stream()
							.map(ClearedGameBoard::getGameBoard)
							.collect(Collectors.toList());
			
			result.forEach(gameBoard -> gameBoard.setCleared(clearedGameBoards.contains(gameBoard)));

		}
		else if (cleared.get()) {
			result = gameBoardRepository.findClearedGameBoards(size, user, pageable);
			result.forEach(gameBoard -> gameBoard.setCleared(true));
		}
		else {
			result = gameBoardRepository.findUnclearedGameBoards(size, user, pageable);
		    result.forEach(gameBoard -> gameBoard.setCleared(false));
		}
		
		
		return result;
	}
	
	public Optional<GameBoard> getRandom(Optional<Integer> size, Optional<Boolean> cleared) {
		MockUser user = userRepository.getReferenceById(1L);

		if (cleared.isEmpty()) {
			return gameBoardRepository.findRandomGameBoard(size, user);
		}
		else if (cleared.get()) {
			return gameBoardRepository.findClearedRandomGameBoard(size, user);
		}
		else {
			return gameBoardRepository.findUnclearedRandomGameBoard(size, user);
		}
	}
}
