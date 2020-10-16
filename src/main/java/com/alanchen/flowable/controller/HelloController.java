package com.alanchen.flowable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alan Chen
 * @description
 * @date 2020/10/13
 */
@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
