package com.jeongneung.JeongneungChingu.service;


import com.jeongneung.JeongneungChingu.domain.dto.UserDto;
import com.jeongneung.JeongneungChingu.domain.entity.User;
import com.jeongneung.JeongneungChingu.exception.CustomAuthException;
import com.jeongneung.JeongneungChingu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String signup(UserDto.Signup request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return "❌ 이미 존재하는 이메일입니다.";
        }

        User user = User.builder()
                .userId(request.getUserId())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
        return "✅ 회원가입 성공!";
    }

    public String login(UserDto.Login loginDto) {
        User user = userRepository.findByUserId(loginDto.getUserId())
                .orElseThrow(() -> new CustomAuthException("존재하지 않는 사용자입니다.", HttpStatus.UNAUTHORIZED));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new CustomAuthException("비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED);
        }

        return "✅ 로그인 성공!";
    }
}
