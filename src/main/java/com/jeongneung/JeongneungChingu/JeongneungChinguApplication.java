package com.jeongneung.JeongneungChingu;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JeongneungChinguApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeongneungChinguApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("정릉친구 API 문서")
						.version("1.0.0")
						.description("Swagger 문서 테스트용 OpenAPI 정보"));
	}
}
