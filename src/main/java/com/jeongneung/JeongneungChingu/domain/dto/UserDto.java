package com.jeongneung.JeongneungChingu.domain.dto;


import lombok.*;

public class UserDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Signup {
        private String userId;
        private String password;
        private String email;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Login {
        private String userId;
        private String password;
    }
}