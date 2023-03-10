package com.wanghao.wiki.controller;

import com.wanghao.wiki.domain.Test;
import com.wanghao.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
//@RequestMapping("/ebook")
public class TestController {
    @Resource
    private TestService testService;

    @Value("${test.hello}")
    private String testHello;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World"+testHello;
    }

    @GetMapping("/list")
    public List<Test> list(){return testService.list();}
}
