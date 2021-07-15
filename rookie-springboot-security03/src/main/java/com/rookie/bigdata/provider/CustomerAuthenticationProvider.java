package com.rookie.bigdata.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Classname CustomerAuthenticationProvider
 * @Description 自定义用户校验器
 * @Author rookie
 * @Date 2021/7/15 11:53
 * @Version 1.0
 */
public class CustomerAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    /**
     * 对用户进行身份的校验，即校验用户名和密码
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取输入用户名 和 密码
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 获取封装用户信息的对象
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
        // 进行密码的比对
        boolean flag = bCryptPasswordEncoder.matches(password, userDetails.getPassword());

        if (flag) {
            // 将权限信息也封装进去
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }

        throw new BadCredentialsException("用户密码错误");
    }

    @Override
    public boolean supports(Class<?> authentication) {

        System.out.println(authentication);
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
