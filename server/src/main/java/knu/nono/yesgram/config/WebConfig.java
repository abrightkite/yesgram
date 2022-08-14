package knu.nono.yesgram.config;

import knu.nono.yesgram.common.GameTypeRequestConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new GameTypeRequestConverter());
		
		WebMvcConfigurer.super.addFormatters(registry);
	}
}
