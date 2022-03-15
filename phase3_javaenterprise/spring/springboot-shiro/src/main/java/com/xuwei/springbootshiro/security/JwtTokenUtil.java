package com.xuwei.springbootshiro.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JwtTokenUtil {

	// token 过期时间
	private static final long EXPIRE_TIME = 30 * 60 * 1000;

	// token 秘钥
	public static final String TOKEN_SECRET = "secret";

	// 请求头
	public static final String AUTH_HEADER = "X-Authorization-With";	// Authorization

	/**
	 * 生成token，30分钟过期
	 *
	 * @param username
	 * @param secret
	 * @return
	 */
	public static String sign(String username, String secret) {
		try {
			LocalDateTime loginTime = LocalDateTime.now();
			Date issueDate = new Date();
			Date expiresDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256(secret);
			// 设置头部信息
            Map<String, Object> header = new HashMap<>(3);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
			// 返回 token 字符串
			return JWT.create()
					.withHeader(header)
					.withClaim("username", username)
					.withClaim("loginTime", loginTime.toString())
					.withIssuedAt(issueDate)
					.withExpiresAt(expiresDate)
					.sign(algorithm);
		} catch (JWTCreationException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 检验 token 是否有效
	 *
	 * @param token
	 * @param username
	 * @param secret
	 * @return
	 */
    public static boolean verify(String token, String username, String secret) {
        try {
            // 设置签名的加密算法：HMAC256
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    /**
     * 验证 token是否过期
     *
     * @param token
     * @return
     */
	public static boolean isExpired(String token) {
		Date now = Calendar.getInstance().getTime();
		DecodedJWT jwt = JWT.decode(token);
		return (jwt.getIssuedAt().before(now) && jwt.getExpiresAt().after(now));
	}

	/**
	 * 刷新 token的过期时间
	 *
	 * @param token
	 * @param secret
	 * @return
	 */
	public static String refreshTokenExpired(String token, String secret) {
		DecodedJWT jwt = JWT.decode(token);
		Map<String, Claim> claims = jwt.getClaims();
		try {
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256(secret);
			Builder builer = JWT.create().withExpiresAt(date);
			for (Entry<String, Claim> entry : claims.entrySet()) {
				builer.withClaim(entry.getKey(), entry.getValue().asString());
			}
			return builer.sign(algorithm);
		} catch (JWTCreationException e) {
			return null;
		}
	}

	/**
	 * 获取 token的签发时间
	 *
	 * @param token
	 * @return
	 */
	public static Date getIssuedAt(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getIssuedAt();
		} catch (JWTDecodeException e) {
			return null;
		}
	}

	/**
	 * 获取token中的username
	 *
	 * @param token
	 * @return
	 */
     public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
         } catch (JWTDecodeException e) {
            e.printStackTrace();
        }
        return null;
    }

	/**
 	 * 获取token中的自定义信息
 	 */
 	public static String getClaimFiled(String token, String filed) {
 		try {
 			DecodedJWT jwt = JWT.decode(token);
 			return jwt.getClaim(filed).asString();
 		} catch (JWTDecodeException e) {
 			return null;
 		}
 	}

 	/**
 	 * 生成16位随机盐
 	 *
 	 * @return
 	 */
	public static String generateSalt() {
		SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
		String hex = secureRandom.nextBytes(16).toHex();
		return hex;
	}
}
