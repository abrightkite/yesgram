package knu.nono.yesgram.repository;

import knu.nono.yesgram.domain.ClearedGameBoard;
import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.domain.MockUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClearedGameBoardRepository extends JpaRepository<ClearedGameBoard, Long> {
	
	List<ClearedGameBoard> findAllByUserAndGameBoardIsIn(MockUser user, List<GameBoard> gameBoards);
}
