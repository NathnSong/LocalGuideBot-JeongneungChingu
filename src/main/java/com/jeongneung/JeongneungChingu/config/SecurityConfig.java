package com.jeongneung.JeongneungChingu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // CSRF 끄기 (보통 API 서버에서 필요)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/login", "/api/users/signup", "/api/chat").permitAll() // 로그인 & 회원가입은 허용
                        .anyRequest().authenticated() // 나머지는 인증 필요
                )
                .build(); // ⬅️ 중요한 부분
    }

    // CORS 구성은 따로 설정!
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:52391"); // Flutter Web dev 서버
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(false); // true이면 origin "*" 사용 금지

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
