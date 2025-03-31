package com.jeongneung.JeongneungChingu.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userKey;  // 내부 DB 식별자 (자동 생성 PK)

    @Column(nullable = false, unique = true)
    private String userId;  // 사용자가 입력하는 로그인 ID

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;
}
