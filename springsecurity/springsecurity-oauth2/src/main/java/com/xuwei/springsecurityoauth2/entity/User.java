package com.xuwei.springsecurityoauth2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Description TODO
 * @Date 2022/2/17 11:16
 * @Author yxw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities; // 授权列表

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
