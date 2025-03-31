package com.jeongneung.JeongneungChingu.repository;

import com.jeongneung.JeongneungChingu.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);
    // 닉네임 중복 체크 등 가능
    boolean existsByEmail(String email); // 이메일 중복 체크
}