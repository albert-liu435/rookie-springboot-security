package com.rookie.bigdata.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Author rookie
 * @Date 2021/7/15 11:30
 * @Version 1.0
 */

@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello() {

        return "hello security";
    }


}
