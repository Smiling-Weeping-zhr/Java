package com.cy.store.util;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * JWT的工具类
 */
public class JwtUtil {
    private static long time = 1000 * 60 * 60 * 1;
    private static String sign = "admin";
    public static String getToken(String phone , String uid){
        //创建一个JwtBuilder对象
        JwtBuilder jwtBuilder = Jwts.builder();
        phone = phone + " " + uid;
        // jwtToken -> abc.def.xyz
        String jwtToken = jwtBuilder
                // Header
                .setHeaderParam("typ" , "JWT")
                .setHeaderParam("alg" , "HS256")
                // payload ：载荷
                .claim("phone" , phone)
                .claim("role" , "admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time)) //Token的过期时间
                .setId(UUID.randomUUID().toString()) // id字段
                //Signature : 签名
                .signWith(SignatureAlgorithm.HS256, sign) //设置加密算法
                // 以上三部分连接成一个字符串
                .compact();

        return jwtToken;
    }

    // 封装验证token是否过期的方法
    public static boolean verify(String token){
        if(token == null || token == ""){
            return false; // false代表过期
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(sign).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 过期
        }
        return true;
    }
    public static String decodeUser(String token){
        JwtParser jwtParser = Jwts.parser(); // 获取JWT的解析对象
        // 类似于Map集合
        Jws<Claims> claimsJws = jwtParser.setSigningKey(sign).parseClaimsJws(token); //将JWT转化成一个Key-value，通过key来获取对应的Value
        // 获取Jws对象中的数据：get(key)标识根据key来获取Value
        Claims claims = claimsJws.getBody(); // 存储的是用户保存的数据
        return claims.get("phone").toString();
    }
}
