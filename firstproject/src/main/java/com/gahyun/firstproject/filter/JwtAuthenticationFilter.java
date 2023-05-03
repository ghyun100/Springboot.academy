package com.gahyun.firstproject.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gahyun.firstproject.provider.JwtTokenProvider;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public JwtAuthenticationFilter (JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        try {
            
            String jwt = parseToken(request);

            boolean hasJwt = jwt != null;
            if (!hasJwt) {
                filterChain.doFilter(request, response);
                return;
            } 
            
            String subject = jwtTokenProvider.validate(jwt); // subject를 꺼내올 수 있음

            AbstractAuthenticationToken authenticationToken = 
                new UsernamePasswordAuthenticationToken(subject, null, AuthorityUtils.NO_AUTHORITIES);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationToken);

            SecurityContextHolder.setContext(securityContext);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        filterChain.doFilter(request, response);

    }
    
    private String parseToken(HttpServletRequest request) {


        //  Request Header 중 "Authorization" : "Bearer eyJh..."
        String token = request.getHeader("Authorization");

        boolean hasToken = 
            token != null && 
            !token.equalsIgnoreCase(null);
        if (!hasToken) return null;

        // "Bearer eyJh..."
        boolean isBearer = token.startsWith("Bearer");
        if (!isBearer) return null;

        // "Bearer eyJh..." : 7번부터 실제 토큰만 가져오겠다는 것
        String jwt = token.substring(7);
        return jwt;
    }

}
