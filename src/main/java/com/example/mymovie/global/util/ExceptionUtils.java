package com.example.mymovie.global.util;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component // 이 클래스를 스프링 컨테이너의 빈으로 등록
public class ExceptionUtils {

    // 제네릭 메서드 정의
    /*
    <T, ID>: 이는 제네릭 타입을 의미합니다. T는 엔티티 타입, ID는 해당 엔티티의 ID 타입을 나타냄
    이렇게 하면 어떤 타입의 엔티티와 ID에도 이 메서드를 사용할 수 있음
     */
    public static <T, ID> T findByIdOrThrow(CrudRepository<T, ID> repository, ID id) {
        // repository의 findById 메서드를 사용하여 엔티티를 조회
        // 만약 결과가 존재하지 않으면, IllegalArgumentException 예외를 발생시킴
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}