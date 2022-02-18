package com.xuwei.springbootvalidation.controller;

import com.xuwei.springbootvalidation.entity.ValidVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

/**
 * @Description 请求校验接口
 * @Date 2022/2/16 10:43
 * @Author yxw
 */
@Slf4j
@Validated
@RestController
public class ValidVoController {

    @PostMapping("/valid/test1")
    public String test1(@Validated @RequestBody ValidVO validVO) {
        log.info("validEntity is {}", validVO);
        return "test1 valid success";
    }

    @PostMapping(value  = "/valid/test2")
    public String test2(@Validated  ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test2 valid success";
    }

    @PostMapping(value  = "/valid/test3")
    public String test3(@Email String email){
        log.info("email is {}", email);
        return "email valid success";
    }
}
