package com.springbootproject.springbootwebservice.domain.config.auth.dto;

import com.springbootproject.springbootwebservice.domain.user.Role;
import com.springbootproject.springbootwebservice.domain.user.UserInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes { //OAuth2UserService를 통해 가져온 OAuth2User의 attribute 등을 담을 클래스

    private Map<String, Object> attributes;
    private String nameAttributesKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String email, String name, String nameAttributeKey, String picture) {
        this.attributes = attributes;
        this.nameAttributesKey = nameAttributeKey;
        this.email = email;
        this.name = name;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public UserInfo toEntity() { //처음 가입시 사용되는 메서드
        return UserInfo.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUSET) //가입시 기본 권한 부여
                .build();
    }
}
