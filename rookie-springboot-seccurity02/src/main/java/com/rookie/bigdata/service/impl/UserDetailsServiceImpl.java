package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.entity.SysRole;
import com.rookie.bigdata.entity.SysUser;
import com.rookie.bigdata.service.SysRoleService;
import com.rookie.bigdata.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserDetailsServiceImpl
 * @Description TODO
 * @Author rookie
 * @Date 2021/7/15 11:55
 * @Version 1.0
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService  sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 根据用户名加载用户 信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        SysUser sysUser = sysUserService.getSysUserByName(username);

        if(null  ==sysUser)
            throw  new UsernameNotFoundException("用户不存在");

        //添加用户的角色
        List<SysRole> sysRoles = sysRoleService.getRoleByUserId(sysUser.getId());

        // 添加角色
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRole role : sysRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        // 构建 Security 的 User 对象
        return new User(sysUser.getUsername(), sysUser.getPassword(), authorities);        // 添加角色


       // return null;
    }
}
