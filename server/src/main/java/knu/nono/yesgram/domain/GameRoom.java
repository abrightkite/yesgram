package knu.nono.yesgram.domain;

import knu.nono.yesgram.common.GameType;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "game_rooms")
public class GameRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String code;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private GameType type;
	
	@Column(nullable = false)
	private int boardSize;
	
	@Column(nullable = false)
	private int maxParticipant;
	
	@Column
	private String password;
	
	@Setter
	@ManyToOne
	private MockUser createdUser;

	@Builder
	public GameRoom(String code, String title, GameType type, int boardSize, int maxParticipant, String password, MockUser createdUser) {
		this.code = code;
		this.title = title;
		this.type = type;
		this.boardSize = boardSize;
		this.maxParticipant = maxParticipant;
		this.password = password;
		this.createdUser = createdUser;
	}
	
	public void createAndSetUUIDCode() {
		code = UUID.randomUUID().toString().substring(0, 8);
	}
}
