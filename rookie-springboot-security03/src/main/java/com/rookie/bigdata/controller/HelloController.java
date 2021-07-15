package com.rookie.bigdata.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Classname HelloController
 * @Description TODO
 * @Author rookie
 * @Date 2021/7/15 16:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/task")
public class HelloController {

    @RequestMapping("/{taskId}")
    public String updateTasks(@PathVariable("taskId") Integer id) {
        return "更新了一下 id: " + id + " 的任务";
    }

    @RequestMapping("/{taskId}")
    public String deleteTasks(@PathVariable("taskId") Integer id) {
        return "删除了 id: " + id + " 的任务";
    }
}
