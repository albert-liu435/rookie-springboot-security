package com.rookie.bigdata.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname CustomUser
 * @Description TODO
 * @Author rookie
 * @Date 2021/7/15 16:47
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class CustomUser implements UserDetails {

    /**
     * username
     */
    private String name;

    /**
     * password
     */
    private String password;

    /**
     * {@link GrantedAuthority}s
     */
    private Set<SimpleGrantedAuthority> authorities;

    public CustomUser(@NonNull SysUser user/*,  List<SimpleGrantedAuthority> grantedAuthorities*/) {
        this.name = user.getUsername();
        this.password = user.getPassword();

//        Set<SimpleGrantedAuthority> authorities =new HashSet<>();
//        for (SimpleGrantedAuthority grantedAuthority : grantedAuthorities) {
//            authorities.add(grantedAuthority);
//        }
//        this.authorities=authorities;

//        for (SysRole sysRole : sysRoles) {
//            this.authorities.add(new SimpleGrantedAuthority(sysRole.getName()));
//        }
        //this.authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public Set<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
