package com.jeongneung.JeongneungChingu.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @PostMapping
    public ResponseEntity<String> chat(@RequestBody Map<String, String> req) {
        String message = req.get("message");
        System.out.println("🗨️ 사용자 질문: " + message);

        // 실제로는 여기서 전처리, AI 호출, 후처리 수행
        String reply = "정릉에 있는 고깃집 중 ○○을 추천합니다!";
        return ResponseEntity.ok(reply);
    }
}
