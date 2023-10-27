package com.cy.store.JWT;

import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class JwtTests {
    private long time = 1000 * 60 * 60 * 1;
    private String sign = "admin";
    @Test
    public void createdJwt(){
        //创建一个JwtBuilder对象
        JwtBuilder jwtBuilder = Jwts.builder();
        // jwtToken -> abc.def.xyz
        String jwtToken = jwtBuilder
                // Header
                .setHeaderParam("typ" , "JWT")
                .setHeaderParam("alg" , "HS256")
                // payload ：载荷
                .claim("username" , "tom")
                .claim("role" , "admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time)) //Token的过期时间
                .setId(UUID.randomUUID().toString()) // id字段
                //Signature : 签名
                .signWith(SignatureAlgorithm.HS256, sign) //设置加密算法
                // 以上三部分连接成一个字符串
                .compact();
        System.out.println(jwtToken);
    }

    //验证JWT
    @Test
    public void checkJwt(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2ODk1ODQzODAsImp0aSI6ImExNzY0NDY5LWMzMWMtNDVjMi1hZDZmLWE5MWIxZTQ0NzNhYSJ9.1V2p-xRbcTI2mPIuZJz-99Cnh--N-pn_ns_UARmTejE";
        boolean result = Jwts.parser().isSigned((token));
        System.out.println(result);
    }
    //解析JWT
    @Test
    public void parseJwt(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2ODk1ODQzODAsImp0aSI6ImExNzY0NDY5LWMzMWMtNDVjMi1hZDZmLWE5MWIxZTQ0NzNhYSJ9.1V2p-xRbcTI2mPIuZJz-99Cnh--N-pn_ns_UARmTejE";
        JwtParser jwtParser = Jwts.parser(); // 获取JWT的解析对象
        // 类似于Map集合
        Jws<Claims> claimsJws = jwtParser.setSigningKey(sign).parseClaimsJws(token); //将JWT转化成一个Key-value，通过key来获取对应的Value
        // 获取Jws对象中的数据：get(key)标识根据key来获取Value
        Claims claims = claimsJws.getBody(); // 存储的是用户保存的数据
        System.out.println(claims.get("username"));
        System.out.println(claims.get("role"));
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getExpiration());
    }
}
