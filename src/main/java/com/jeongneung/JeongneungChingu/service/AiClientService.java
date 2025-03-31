package com.jeongneung.JeongneungChingu.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AiClientService {

    private final RestTemplate restTemplate;
    private final String FLASK_API_URL = "http://localhost:5000/chat"; // 또는 실제 IP

    public AiClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String queryAiServer(String message) {
        Map<String, String> request = new HashMap<>();
        request.put("message", message);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

        try {
            // 🔥 여기!
            ResponseEntity<Map> response = restTemplate.postForEntity(FLASK_API_URL, entity, Map.class);

            String aiMessage = (String) response.getBody().get("response");
            System.out.println("🤖 AI 응답: " + aiMessage);

            return aiMessage;

        } catch (Exception e) {
            e.printStackTrace();
            return "❌ AI 서버와의 통신 실패: " + e.getMessage();
        }
    }
}
