package com.jaewon.blog.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
//  이 어노테이션이 생성 될 수 있는 위치를 지정
//  Prameter로 지정했으니 메소드의 파라미티로 선언된 객체에서만 사용 가능
//  이 외에도 클래스 선언문에 쓸 수 있는 TYPE 등이 있다.
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    //  @interface : 이 파일을 어노테이션 클래스로 지정, LoginUser라는 이름을 가진 어노테이션이 생성된거다.
}
