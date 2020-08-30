package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: demo
 * @Date: 2020/8/30 16:31
 * @Author: tianlg
 */
@RestController
@RequestMapping("/hello")
public class DemoController {

    @GetMapping
    public String index() {
        return "Hello World";
    }
}
