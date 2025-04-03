package com.jeongneung.JeongneungChingu.api;


import com.jeongneung.JeongneungChingu.service.AiClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chat") //채팅 엔드포인트
public class ChatController {

    private final AiClientService aiClientService;

    public ChatController(AiClientService aiClientService) {
        this.aiClientService = aiClientService;
    }

    @PostMapping(produces = "application/json; charset=UTF-8")
    public ResponseEntity<Map<String, String>> chat(@RequestBody Map<String, String> req) {
        String message = req.get("message");
        //String aiResponse = aiClientService.queryAiServer(message);
        String responseMessage = "받은 메시지: " + message;
        System.out.println("응답받은 메시지: " + message);
        return ResponseEntity.ok(Map.of("response", responseMessage));
    }

}
