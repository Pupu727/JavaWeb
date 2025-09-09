package com.lirui.ultis;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String Key = "V2FpdGluZyB0aGUgZnVubnkgY29kZSB0byBkZXZlbG9wIHlvdXIgcHJvamVjdA==";
    private static final long Expire = 1000 * 60 * 60 * 24 ;
    public static String createToken(Map<String,Object> claims){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,Key)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + Expire))
                .compact();
    }
    public static Map<String,Object> parseToken(String token){
        return Jwts.parser()
                .setSigningKey(Key)
                .parseClaimsJws(token)
                .getBody();
    }
}
