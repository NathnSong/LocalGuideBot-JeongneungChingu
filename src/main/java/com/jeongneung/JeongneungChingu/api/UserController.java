package com.jeongneung.JeongneungChingu.api;

import com.jeongneung.JeongneungChingu.domain.dto.UserDto;
import com.jeongneung.JeongneungChingu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDto.Signup request) {
        String result = userService.signup(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto.Login loginDto) {
        try {
            String result = userService.login(loginDto);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("❌ 로그인 실패: " + e.getMessage());
        }
    }
}
