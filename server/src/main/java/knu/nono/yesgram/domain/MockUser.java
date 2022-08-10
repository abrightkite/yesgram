package knu.nono.yesgram.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "temp_users")
public class MockUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String loginId;

	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private Set<ClearedGameBoard> clearedGameBoards = new HashSet<>();
}
