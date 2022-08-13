package knu.nono.yesgram.dto;

import knu.nono.yesgram.common.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateGameRoomRequest {
	
	@NotBlank(message = "방 제목이 비어있습니다.")
	@Size(max = 50, message = "최대 길이는 50입니다.")
	private String title;
	
	@NotNull
	private GameType type;
	
	@NotNull
	private int boardSize;

	@NotNull
	@Min(2)
	@Max(8)
	private int maxParticipant;

	@NotNull
	private boolean usePassword;

	@Size(min = 1, max = 20)
	private String password;
}
