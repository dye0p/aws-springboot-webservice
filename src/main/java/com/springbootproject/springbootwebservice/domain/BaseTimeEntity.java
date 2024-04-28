package com.springbootproject.springbootwebservice.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들도 컬럼으로 인식하도록 함.
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity클래스에 Auditing 기능을 포함시킴
public abstract class BaseTimeEntity { //추상화 클래스

    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동으로 저장됨.
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할 때 시간이 자동으로 저장됨.
    private LocalDateTime modifiedDate;
}
