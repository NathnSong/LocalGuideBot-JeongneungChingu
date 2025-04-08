package com.jeongneung.JeongneungChingu.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AiClientService {

    private final RestTemplate restTemplate;
    private final String FLASK_API_URL = "http://223.130.152.181:8080/chat"; // AI서버 엔드포인트.나중에 수정필요

    public AiClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String queryAiServer(String message) { //사용자 메시지 수신 → Flask에 POST로 보내고 → 응답 메시지를 리턴함
        Map<String, String> request = new HashMap<>();
        request.put("message", message);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); //http형식을 JSON으로 보내겠다고 선언
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<Map> response =
                    restTemplate.postForEntity(FLASK_API_URL, entity, Map.class);//AI서버에 POST요청 보내기

            String aiMessage = (String) response.getBody().get("response"); //AI로부터 받은 응답 파싱
            System.out.println("AI 응답: " + aiMessage);

            return aiMessage;

        } catch (Exception e) {
            e.printStackTrace();
            return "AI 서버와의 통신 실패: " + e.getMessage();
        }
    }
}
