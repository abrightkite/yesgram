package knu.nono.yesgram.repository;

import knu.nono.yesgram.domain.GameBoard;
import knu.nono.yesgram.domain.MockUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GameBoardRepository extends JpaRepository<GameBoard, Long> {

	@Query("select gb from GameBoard gb " +
			"where (:size is null or gb.size = :size)"
	)
	Page<GameBoard> findGameBoards(@Param("size") Optional<Integer> size, 
	                               Pageable pageable);
	
	@Query("select gb from GameBoard gb " +
			"join ClearedGameBoard cu " +
			"on cu.user = :user and cu.gameBoard = gb " +
			"where (:size is null or gb.size = :size)"
	)
	Page<GameBoard> findClearedGameBoards(@Param("size") Optional<Integer> size, 
	                                      @Param("user") MockUser user, 
	                                      Pageable pageable);

	@Query("select gb from GameBoard gb " +
			"left join ClearedGameBoard cu " +
			"on cu.user = :user and cu.gameBoard = gb " +
			"where (:size is null or gb.size = :size) and " +
			"cu.id is null"
	)
	Page<GameBoard> findUnclearedGameBoards(@Param("size") Optional<Integer> size, 
	                                        @Param("user") MockUser user, 
	                                        Pageable pageable);
	
	@Query(value = "select * from game_boards as gb " +
			"left join cleared_game_boards as cgb " +
			"on cgb.user_id = :#{#user.id} and cgb.game_board_id = gb.id " +
			"where (:size is null or gb.size = :size) " +
			"order by rand() limit 1",
			nativeQuery = true
	)
	Optional<GameBoard> findRandomGameBoard(@Param("size") Optional<Integer> size,
	                              @Param("user") MockUser user);

	@Query(value = "select * from game_boards as gb " +
			"join cleared_game_boards as cgb " +
			"on cgb.user_id = :#{#user.id} and cgb.game_board_id = gb.id " +
			"where (:size is null or gb.size = :size) " +
			"order by rand() limit 1",
			nativeQuery = true
	)
	Optional<GameBoard> findClearedRandomGameBoard(@Param("size") Optional<Integer> size, 
	                                               @Param("user") MockUser user);

	@Query(value = "select * from game_boards as gb " +
			"left join cleared_game_boards as cgb " +
			"on cgb.user_id = :#{#user.id} and cgb.game_board_id = gb.id " +
			"where (:size is null or gb.size = :size) and " +
			"cgb.id is null " +
			"order by rand() limit 1",
			nativeQuery = true
	)
	Optional<GameBoard> findUnclearedRandomGameBoard(@Param("size") Optional<Integer> size, 
	                                                 @Param("user") MockUser user);
}
