package knu.nono.yesgram.repository;

import knu.nono.yesgram.domain.GameBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GameBoardRepository extends JpaRepository<GameBoard, Long> {

	@Query("select gb from GameBoard gb " +
			"left join gb.clearedUsers cu " +
			"where (:size is null or gb.size = :size)"
	)
	Page<GameBoard> findGameBoards(@Param("size") Optional<Integer> size, Pageable pageable);
	
	@Query("select gb from GameBoard gb " +
			"join gb.clearedUsers cu " +
			"where (:size is null or gb.size = :size)"
	)
	Page<GameBoard> findClearedGameBoards(@Param("size") Optional<Integer> size, Pageable pageable);

	@Query("select gb from GameBoard gb " +
			"left join gb.clearedUsers cu " +
			"where (:size is null or gb.size = :size) and " +
			"cu.id is null"
	)
	Page<GameBoard> findUnclearedGameBoards(@Param("size") Optional<Integer> size, Pageable pageable);
}
