package com.gahyun.firstproject.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
    
    // JWT 생성 또는 검증에 사용될 시크릿 키
    // 시크릿 키 같은 데이터는 보단에 유의해야 하기 때문에 
    // application.properties 또는 환경변수로 등록해서 사용
    @Value("${jwt.secret-key}")
    private String SECRET_KEY;

    // JWT 생성 메서드
    public String create(String subject) {
        
        Date expireDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String jwt = 
                    Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .setSubject(subject)
                    .setIssuedAt(new Date())
                    .setExpiration(expireDate)
                    .compact();
        return jwt;

    }

    // JWT 검증
    public String validate(String jwt) {
        Claims claims = 
            Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();

        return claims.getSubject();
    }

}
