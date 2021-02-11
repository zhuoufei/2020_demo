package com.zf.mo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {

    private static final String SUBJECT = "ZHOUF";

    private static final long EXPIRE = 1000*60*60*24*7;

    //秘钥
    private static final String APPSECRET = "ZHOUFEI";

    public static String geneWebToKen(){
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", "123")
                .claim("name", "zf")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET)//不使用公私钥
//                .signWith(SignatureAlgorithm.RS512,privateK)
                .compact();
        return token;
    }

    public static Claims checkJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET)
                .parseClaimsJws(token).getBody();
        return claims;
    }

    public static void main(String[] args) {
        String s = geneWebToKen();
        System.out.println("s:"+s);
        Claims claims = checkJWT(s);
        System.out.println("claims:"+claims);
    }

}
