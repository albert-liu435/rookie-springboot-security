package com.rookie.bigdata.filter;

import com.rookie.bigdata.entity.CustomUser;
import com.rookie.bigdata.entity.SysUser;
import com.rookie.bigdata.service.SysUserService;
import com.rookie.bigdata.util.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname JWTAuthorizationFilter
 * @Description 鉴权过滤器
 * @Author rookie
 * @Date 2021/7/15 16:01
 * @Version 1.0
 */
public class JWTAuthorizationFilter extends OncePerRequestFilter {


    @Autowired
    private SysUserService sysUserService;


    private static final Set<String> WHITE_LIST = Stream.of("/auth/register").collect(Collectors.toSet());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //log.debug("authorization filter doFilterInternal");
        final String authorization = request.getHeader(JWTUtils.TOKEN_HEADER);
        //   log.debug("raw-access-token: {}", authorization);

        // Branch A: 如果请求头中没有 Authorization
        if (StringUtils.isBlank(authorization)) {
            // 白名单放行
//            if (WHITE_LIST.contains(request.getRequestURI())) {
//                chain.doFilter(request, response);
//            } else {
//                response.getWriter().write("未经授权的访问!");
//            }
            response.getWriter().write("未经授权的访问!");
            return;
        }

        // Branch B: 如果请求头中有 Bear xxx, 设置认证信息
        final String jsonWebToken = authorization.replace(JWTUtils.TOKEN_PREFIX, StringUtils.EMPTY);

        // TODO 用 Redis 的过期控制 token, 而不用 jwt 的 Expiration
        // if (JWTUtils.hasExpired(jsonWebToken)) {
        //     response.getWriter().write("access-token 已过期, 请重新登陆!");
        // }
        // TODO 每一次携带正确 token 的访问, 都刷新 Redis 的过期时间

        CustomUser user = JWTUtils.userDetails(jsonWebToken);

        //查询出用户信息

   //    SysUser sysUser = sysUserService.getSysUserByName(user.getUsername());

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        // TODO Json Web Token 中不能携带用户密码
                        user.getPassword(),
                        user.getAuthorities()
                )
        );
        chain.doFilter(request, response);
    }
}
