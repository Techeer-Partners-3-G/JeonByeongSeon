package com.example.mymovie.global.common;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass // 이 클래스가 다른 엔티티 클래스에 속성을 상속하는 데 사용됨을 나타냄
@EntityListeners(AuditingEntityListener.class) // JPA의 엔티티 생명주기 이벤트 처리를 위해 AuditingEntityListener 사용
public abstract class BaseEntity {

    @Schema(description = "엔티티가 생성된 날 ")
    @CreatedDate // 엔티티 생성 시 자동으로 현재 시간으로 설정
    @Column(nullable = false, updatable = false) // null 허용 안함, 업데이트 안됨
    private LocalDateTime createdAt;

    @Schema(description = "엔티티가 마지막으로 수정된 날짜")
    @LastModifiedDate // 엔티티 수정 시 자동으로 현재 시간으로 업데이트
    @Column(nullable = false) // null 허용 안함
    private LocalDateTime updatedAt;

    @Schema(description = "엔티티가 삭제된 날짜", required = false)
    @Column(nullable = true) // null 허용 (삭제되지 않은 경우 null)
    /*
    소프트 삭제" (soft delete) 전략을 구현하기 위함
    소프트 삭제는 데이터베이스 레코드를 실제로 삭제하지 않고, 대신 삭제된 것으로 표시하는 방법
     */
    private LocalDateTime deletedAt;



    // 기본 생성자
    public BaseEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}