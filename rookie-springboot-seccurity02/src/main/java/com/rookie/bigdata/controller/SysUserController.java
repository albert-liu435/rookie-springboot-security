package com.rookie.bigdata.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rookie
 * @since 2021-07-15
 */
@RestController
@RequestMapping("sys")
public class SysUserController {


    @RequestMapping("/getUser")
    public String getUser() {


        return "hello  security";
    }

}
