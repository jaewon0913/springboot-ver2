package com.jaewon.blog.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//  스프링부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정된다.
//  @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야한다.
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
