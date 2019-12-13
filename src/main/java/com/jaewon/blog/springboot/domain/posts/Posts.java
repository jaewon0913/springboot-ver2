package com.jaewon.blog.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //  Getter 메소드 생성
@NoArgsConstructor  //  기본 생성자 자동 추가.(ex: public Post(){}와 같은 효과)
@Entity //  테이블과 링크될 클래스임을 나타낸다. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭할 수 있다.(ex: JaewonBoard.java -> jaewon_board table)
public class Posts {

    @Id //  해당 테이블의 PK(Primary Key)필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  PK의 생성 규칙을 타나낸다.
    private Long id;

    @Column(length = 500, nullable = false)
    //  테이블의 칼럼을 나타내며 굳이 선언하지 않더라 해당 클래스의 필드는 모두 칼럼이 된다.(기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용)
    //  ex: 사이즈를 늘린다던지 타입을 TEXT로 변경 등
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts (String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
