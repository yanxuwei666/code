package com.xuwei.springsecurityapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!Objects.equals("admin", username)){
            System.out.println("用户记录不存在!");
            return null;
        }
        String password = encoder.encode("123");
        return new User(username,password, AuthorityUtils.
                commaSeparatedStringToAuthorityList("admin,normal,ROLE_abc"));
    }
}
