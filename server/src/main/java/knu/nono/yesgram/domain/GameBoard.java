package knu.nono.yesgram.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "game_boards")
public class GameBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer size;

	@Column(nullable = false)
	private String answer;
	
	@OneToMany(mappedBy = "gameBoard")
	private Set<ClearedGameBoard> clearedUsers = new HashSet<>();
}
