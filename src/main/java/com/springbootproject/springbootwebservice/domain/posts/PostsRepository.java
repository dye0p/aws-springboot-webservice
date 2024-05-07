package com.springbootproject.springbootwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p from Posts p order by p.id desc") //직접 쿼리를 정의(QueryDsl)
    List<Posts> findAllDesc(); //해당 메서드가 실행되면 위의 쿼리문이 실행된다.
}
