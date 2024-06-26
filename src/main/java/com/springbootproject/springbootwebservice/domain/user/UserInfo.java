package com.springbootproject.springbootwebservice.domain.user;

import com.springbootproject.springbootwebservice.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Getter
@NoArgsConstructor
@Entity
public class UserInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public UserInfo(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    /*비즈니스 로직*/
    public UserInfo update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    /*비즈니스 로직*/
    public String getRoleKey() {
        return this.role.getKey();
    }
}
