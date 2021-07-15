package com.rookie.bigdata.filter;

import com.fasterxml.jackson.core.sym.NameN;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rookie.bigdata.constant.SecurityConstant;
import com.rookie.bigdata.entity.CustomUser;
import com.rookie.bigdata.entity.SysUser;
import com.rookie.bigdata.util.JWTUtils;
import lombok.SneakyThrows;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Classname JWTAuthenticationFilter
 * @Description 用户名和密码过滤器，用于校验用户的身份
 * @Author rookie
 * @Date 2021/7/15 15:12
 * @Version 1.0
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        //this.setAuthenticationSuccessHandler();
        // 浏览器访问 http://localhost:8087/sys/login 会通过 JWTAuthenticationFilter
        super.setFilterProcessesUrl(SecurityConstant.LOGIN_URI);

        //super.setUsernameParameter("name");
    }

    /**
     * 尝试进行身份认证
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //获取用户的信息
        Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder = new Jackson2ObjectMapperBuilder();
        ObjectMapper build = jackson2ObjectMapperBuilder.build();
        SysUser sysUser = build.readValue(request.getInputStream(), SysUser.class);

        //封装UsernamePasswordAuthenticationToken进行身份验证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword());
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //return super.attemptAuthentication(request, response);
    }


    /**
     * 身份认证成功之后的操作
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //获取用户的信息
        CustomUser user = (CustomUser) authResult.getPrincipal();
        //根据用户的信息，生成token并返回到前端

        response.setHeader("access-token",
                JWTUtils.TOKEN_PREFIX + JWTUtils.create(user.getUsername(), false, user));

        response.getWriter().write("sucess");
        //super.successfulAuthentication(request, response, chain, authResult);
    }


    /**
     * 身份认证失败时，即抛出异常的情况下调用该方法
     *
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());

        //  super.unsuccessfulAuthentication(request, response, failed);
    }
}
