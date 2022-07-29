package knu.nono.yesgram.repository;

import knu.nono.yesgram.domain.GameRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRoomRepository extends JpaRepository<GameRoom, Long> {
}
