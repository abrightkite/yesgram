package knu.nono.yesgram.common;

import org.springframework.core.convert.converter.Converter;

// Request Param에서 GameType을 Convert하기위한 클래스. 현재는 쓸일이 없긴함
public class GameTypeRequestConverter implements Converter<String, GameType> {
	@Override
	public GameType convert(String gameType) {
		return GameType.valueOf(gameType.toUpperCase());
	}
}
