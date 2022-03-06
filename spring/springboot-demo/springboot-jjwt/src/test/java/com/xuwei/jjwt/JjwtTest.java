package com.xuwei.jjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 获取JWT
 * @Date 2022/3/4 10:16
 * @Author yxw
 */
@SpringBootTest
public class JjwtTest {

    /**
     * 创建Token
     */
    @Test
    public void testCreateToken() {
        System.out.println("获取token");

        // 创建一个JwtBuilder对象
        JwtBuilder jwtBuilder = Jwts.builder()
                // 声明的标识{"jti":"888"}
                .setId("888")
                // 主体，用户{"sub":"Rose"}
                .setSubject("Rose")
                // 创建日期{"ita":"xxxxxx"}
                .setIssuedAt(new Date())
                // 签名手段，参数1：算法，参数2：盐
                .signWith(SignatureAlgorithm.HS256, "xxxx");
        // 获取jwt的token
        String token = jwtBuilder.compact();
        System.out.println(token);

        // 三部分的base64解密
        String[] tokenSplit = token.split("\\.");
        // {"alg":"HS256"}
        System.out.println(Base64Codec.BASE64.decodeToString(tokenSplit[0]));
        // {"jti":"888","sub":"Rose","iat":1646360468
        System.out.println(Base64Codec.BASE64.decodeToString(tokenSplit[1]));
        // 无法解密
        System.out.println(Base64Codec.BASE64.decodeToString(tokenSplit[2]));
    }

    /**
     * token过期校验
     */
    @Test
    public void testCreateTokenHasExp() {
        long now = System.currentTimeMillis();
        // 设置过期时间，这里是1分钟后的时间长整型
        long exp = now + 60 * 1000;
        JwtBuilder jwtBuilder = Jwts.builder()
                //声明的标识{"jti":"888"}
                .setId("888")
                //主体，用户{"sub":"Rose"}
                .setSubject("Rose")
                //创建日期{"ita":"xxxxxx"}
                .setIssuedAt(new Date())
                //签名手段，参数1：算法，参数2：盐
                .signWith(SignatureAlgorithm.HS256, "xxxx")
                // 设置过期时间
                .setExpiration(new Date(exp));
        String token = jwtBuilder.compact();
        System.out.println(token);
    }


    /**
     * 自定义Claims
     */
    @Test
    public void testCreateTokenByClaims() {
        long now = System.currentTimeMillis();
        // 设置过期时间，这里是1分钟后的时间长整型
        long exp = now + 60 * 1000;
        JwtBuilder jwtBuilder = Jwts.builder()
                //声明的标识{"jti":"888"}
                .setId("888")
                //主体，用户{"sub":"Rose"}
                .setSubject("Rose")
                //创建日期{"ita":"xxxxxx"}
                .setIssuedAt(new Date())
                //签名手段，参数1：算法，参数2：盐
                .signWith(SignatureAlgorithm.HS256, "xxxx")
                // 设置过期时间
                .setExpiration(new Date(exp))
                // 直接传入map也可以 .addClaims(map)
                .claim("roles", "admin")
                .claim("logo", "shsd.jpg");
        String token = jwtBuilder.compact();
        System.out.println(token);
    }

    /**
     * 解析token，在web应用中客户端登录成功后服务器会返回给客户端一个token，之后客户端每次请求都需要携带这个token，服务器拿到这个token时就应该要解析出token中的信息
     */
    @Test
    public void testParseToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjQ2MzYxMjIwLCJleHAiOjE2NDYzNjEyODAsInJvbGVzIjoiYWRtaW4iLCJsb2dvIjoic2hzZC5qcGcifQ.41yPcSw0Lp_AQ0b3nXGh513IUP8qs7pc_UJgym4olZ8";
        // 解析token获取负载中的声明对象
        Claims claims = Jwts.parser()
                .setSigningKey("xxxx")
                .parseClaimsJws(token)
                .getBody();
        // 打印声明的属性
        System.out.println("id:"+claims.getId()); // 888
        System.out.println("subject:"+claims.getSubject()); // Rose
        System.out.println("issuedAt:"+claims.getIssuedAt()); // Fri Mar 04 10:22:04 CST 2022

        DateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("签发时间:"+sf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sf.format(new Date()));

        System.out.println("roles:"+claims.get("roles"));
        System.out.println("logo:"+claims.get("logo"));
    }
}
