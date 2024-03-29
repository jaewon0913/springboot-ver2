package com.jaewon.blog.springboot.web;

import com.jaewon.blog.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//  컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
//  예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각
public class HelloController {

    @GetMapping("/hello")
    //  Http Method인 Get의 요청을 받을 수 있는 API
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        //  @RequestParam
        //  - 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        //  - 여기선 name으로 넘긴 파라미터를 메소드 파라미터 String name으로 저장
        return new HelloResponseDto(name, amount);
    }
}
