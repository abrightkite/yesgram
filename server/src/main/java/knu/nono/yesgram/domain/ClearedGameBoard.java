package knu.nono.yesgram.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "cleared_game_boards")
public class ClearedGameBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "game_board_id")
	private GameBoard gameBoard;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private MockUser user;
}
