package com.jaewon.blog.springboot.web;

import com.jaewon.blog.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//  테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행(여기서는 SpringRunner라는 스프링 실행자)
//  스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        })
//  Web(Spring MVC)에 집중할 수 있는 어노테이션
//  @Controller, @ControllerAdvice 등 사용 가능(@Service, @Component, @Repository 등은 사용 X)
public class HelloControllerTest {

    @Autowired  //  스프링이 관리하는 빈(Bean)을 주입
    private MockMvc mvc;    //  웹 API 테스트에 사용(스프링 MVC 테스트의 시작점) , HTTP GET/POST 등 테스트 가능

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))          //  MockMVC를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk())            //  mvc.perform의 결과를 검증, HTTP Header의 Status 검증(200, 404, 500 등)
                .andExpect(content().string(hello));   //  응답 본문의 내용을 검증, Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                //  param : API 테스트할 때 사용될 요청 파라미터를 설정(값은 String만 허용 -> 숫자/날짜 등의 데이터는 문자열로 변경해야함)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                //  jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드, $를 기준으로 필드명을 명시
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}