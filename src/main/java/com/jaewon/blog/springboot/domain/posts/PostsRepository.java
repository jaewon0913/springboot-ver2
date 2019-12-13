package com.jaewon.blog.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //  DB Layer 접근자 -> JPA에선 Repository라고 부르며 인터페이스로 생성한다.
    //  자동으로 CRUD 메소드가 생성된다.
    //  @Repository를 추가할 필요가 없다.(Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다.)
}
