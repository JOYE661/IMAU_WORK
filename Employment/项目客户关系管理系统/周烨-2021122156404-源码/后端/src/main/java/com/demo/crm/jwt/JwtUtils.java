package com.demo.crm.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static String secret = "ThisIsNeuedu";//密钥
    private static String issuer = "Server";//发布者
    private static String subject = "LoginToken";//主题
    private static String audience = "Client";//签名的观众,谁接受签名
    private static Algorithm algorithm;
    private static JWTVerifier jwtVerifier;

    static {
        algorithm = Algorithm.HMAC256(secret);
        jwtVerifier = JWT.require(algorithm).withIssuer(issuer).build();
    }

    // String token = "Bearer " + JwtUtils.createToken(dbAdmin.getId(), dbAdmin.getUsername(), 60 * 60 * 2);
    public static String createToken(Integer userId, String username, long seconds) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + seconds * 1000);// 计算失效时间

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withHeader(map)
                // 自定义
                .withClaim("userid", userId)// 载荷 Payload
                .withClaim("username", username)// 载荷 Payload
                .withIssuer(issuer)// 签名是有谁生成 例如 服务器
                .withSubject(subject)// 签名的主题
                .withNotBefore(nowDate)//定义在什么时间之前，该jwt都是不可用的
                .withAudience(audience)// 签名的观众 也可以理解谁接受签名的
                .withIssuedAt(nowDate) // 生成签名的时间
                .withExpiresAt(expireDate)// 签名过期的时间
                .sign(algorithm);//签名 Signature
        return token;
    }

    // encode
    // decode
    public static DecodedJWT verifyToken(String token) {
        return jwtVerifier.verify(token);
    }


//    public static void main(String[] args) {
//        //String token = createToken("admin", 5);
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVc2VyTG9naW5Ub2tlbiIsImF1ZCI6IkNsaWVudCIsIm5iZiI6MTYwNDQ5NDM0MywiaXNzIjoiU2VydmVyIiwiZXhwIjoxNjA0NDk0MzQ4LCJpYXQiOjE2MDQ0OTQzNDMsInVzZXJuYW1lIjoiYWRtaW4ifQ.Z4Uc4AHTI6MzonurYv4xWxcI5g0M7Kx-dAFKzgjuoJ0";
//        System.out.println(token);
//        System.out.println(verifyToken(token));
//    }
}
