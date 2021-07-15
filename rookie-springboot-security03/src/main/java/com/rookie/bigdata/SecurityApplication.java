package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname SecurityApplication
 * @Description 在浏览器中输入 http://localhost:8087/sys/login,会跳转到相应的登录页面
 * {
 *     "username":"admin",
 *     "password":"123456"
 *     }
 *     根据返回的token进行第二次调用
 *     http://localhost:8087/task/2
 *     Authorization  Bearer eyJhbGciOiJIUzUxMiJ9.eyJwYXNzd29yZCI6IiQyYSQxMCRnYm9VV1l0UDBpNkpYL0FTOE5tak9lc29nclNXYUVHWDlFZVNtc1ZHVHcza3dTdXpuL0MzRyIsImNyZWRlbnRpYWxzTm9uRXhwaXJlZCI6dHJ1ZSwibmFtZSI6ImFkbWluIiwiYWNjb3VudE5vbkV4cGlyZWQiOnRydWUsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiLnrqHnkIblkZgifV0sImVuYWJsZWQiOnRydWUsImFjY291bnROb25Mb2NrZWQiOnRydWUsInVzZXJuYW1lIjoiYWRtaW4iLCJzdWIiOiJhZG1pbiIsImlhdCI6MTYyNjMzOTU5MCwiaXNzIjoicm9va2llIn0.vw_UiSJDMivQgWyrbv09BbO79rF0uWFlfdV98beww9wDsUjetOacZ96zHPHBFdPKn1seS3ygTILDoV3J6aAruA
 * @Author rookie
 * @Date 2021/7/15 11:47
 * @Version 1.0
 */
@SpringBootApplication
public class SecurityApplication {


    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}