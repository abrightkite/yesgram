package knu.nono.yesgram.repository;

import knu.nono.yesgram.domain.GameBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GameBoardRepository extends JpaRepository<GameBoard, Long> {

	@Query("select gb from GameBoard gb " +
			"left join fetch gb.clearedUsers cu " +
			"where (:size is null or gb.size = :size)"
	)
	List<GameBoard> findGameBoards(@Param("size") Optional<Integer> size);
	
	@Query("select gb from GameBoard gb " +
			"join fetch gb.clearedUsers cu " +
			"where (:size is null or gb.size = :size)"
	)
	List<GameBoard> findClearedGameBoards(@Param("size") Optional<Integer> size);

	@Query("select gb from GameBoard gb " +
			"left join fetch gb.clearedUsers cu " +
			"where (:size is null or gb.size = :size) and " +
			"cu.id is null"
	)
	List<GameBoard> findUnclearedGameBoards(@Param("size") Optional<Integer> size);
}
