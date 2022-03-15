package com.xuwei.auth.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description TODO
 * @Date 2022/3/9 15:08
 * @Author yxw
 */
public class TestBCryptPasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("code-secret-8888"));
        System.out.println(passwordEncoder.matches("code-secret-8888", "$2a$10$jENDQZRtqqdr6sXGQK.L0OBADGIpyhtaRfaRDTeLKI76I/Ir1FDn6"));
    }
}
