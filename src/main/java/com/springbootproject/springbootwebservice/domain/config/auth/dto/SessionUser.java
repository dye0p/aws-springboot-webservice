package com.springbootproject.springbootwebservice.domain.config.auth.dto;


import com.springbootproject.springbootwebservice.domain.user.UserInfo;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { //세션에 사용자 정보를 저장하기 위한 Dto 클래스

    //인증된 사용자 정보만 필요
    private String name;
    private String email;
    private String picture;

    public SessionUser(UserInfo userInfo) {
        this.name = userInfo.getName();
        this.email = userInfo.getEmail();
        this.picture = userInfo.getPicture();
    }
}
