package knu.nono.yesgram.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
	private String type;
	
	@Column(nullable = false)
	private int boardSize;
	
	@Column(nullable = false)
	private int maxParticipant;
	
	private String password;
	
	@Column(nullable = false)
	private Long createdUserId;
}
