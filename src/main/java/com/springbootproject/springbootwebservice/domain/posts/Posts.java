package com.springbootproject.springbootwebservice.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*주요 어노테이션을 클래스에 가깝게 배치*/
@Getter
@NoArgsConstructor //기본 생성자 자동 추가 public Posts() {}와 같은 효과
@Entity
public class Posts { //실제 DB와 매칭될 Entity 클래스

    @Id //해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK_auto_increment
    public Long id;

    @Column(length = 500, nullable = false) //VARCHAR(500), NOT NULL
    public String title;

    @Column(columnDefinition = "TEXT", nullable = false) //Type:"TEXT", NOT NULL
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자의 포함된 필드만 빌더에 포함
    public Posts(String content, String author, String title) {
        this.content = content;
        this.author = author;
        this.title = title;
    }

    /*Entity 클ㄹ스에는 절대 Setter 메소드를 만들지 않는다.
    * 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다*/
}
