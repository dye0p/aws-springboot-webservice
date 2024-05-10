package com.springbootproject.springbootwebservice.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

    //이메일을 통해 이미 가입된 사용자인지 확인
    Optional<UserInfo> findByEmail(String email);
}

