package knu.nono.yesgram.repository;

import knu.nono.yesgram.domain.GameBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameBoardRepository extends JpaRepository<GameBoard, Long> {
}
