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

import java.util.ArrayList;
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

		    setGameBoardClearedField(result.getContent(), user);
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
	
	public Optional<GameBoard> getRandomGameBoard(Optional<Integer> size, Optional<Boolean> cleared) {
		MockUser user = userRepository.getReferenceById(1L);
		
		Optional<GameBoard> result;
		if (cleared.isEmpty()) {
			result = gameBoardRepository.findRandomGameBoard(size);
			result.ifPresent(gameBoard -> setGameBoardClearedField(gameBoard, user));
		}
		else if (cleared.get()) {
			result =  gameBoardRepository.findClearedRandomGameBoard(size, user);
			result.ifPresent(gameBoard -> gameBoard.setCleared(true));
		}
		else {
			result =  gameBoardRepository.findUnclearedRandomGameBoard(size, user);
			result.ifPresent(gameBoard -> gameBoard.setCleared(false));
		}
		
		return result;
	}
	
	private void setGameBoardClearedField(List<GameBoard> targetGameBoards, MockUser user) {
		List<GameBoard> clearedGameBoards =
				cgbRepository
						.findAllByUserAndGameBoardIsIn(user, targetGameBoards)
						.stream()
						.map(ClearedGameBoard::getGameBoard)
						.collect(Collectors.toList());

		targetGameBoards.forEach(gameBoard -> gameBoard.setCleared(clearedGameBoards.contains(gameBoard)));
	}
	
	private void setGameBoardClearedField(GameBoard targetGameBoard, MockUser user) {
		List<GameBoard> list = new ArrayList<>();
		list.add(targetGameBoard);
		
		setGameBoardClearedField(list, user);
	}
}
