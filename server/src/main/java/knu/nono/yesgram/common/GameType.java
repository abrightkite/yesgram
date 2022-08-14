package knu.nono.yesgram.common;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum GameType {
	SOLO, // 멀티 - 개인전
	TEAM; // 멀티 - 팀전
	
	@JsonCreator
	public static GameType from(String gameType) {
		return GameType.valueOf(gameType.toUpperCase());
	}
}
