package com.authentication.app.filter;

//import com.securityjwt.app.MyUserDetailsService;
import com.authentication.app.jwt.JwtUtil;
import com.authentication.app.service.DefaultUserServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginRequestFilter extends OncePerRequestFilter {

    @Autowired
    private DefaultUserServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
     System.out.println(request.getRequestURI());

        if (request.getRequestURI().matches("/v1(.*)")){
            System.out.println("Hello");
            return true;
         }else{
             return false;
         }
        
	}
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        
        String jwt = null;
        Cookie[] cookies = request.getCookies();
    
    if (cookies != null) {
        // Loop through the cookies to find the Login token cookie
        for (Cookie cookie : cookies) {
            if ("LoginToken".equals(cookie.getName())) {
                jwt = cookie.getValue();
            }
        }
        }
    try{
        String username = null;
        if (jwt != null) {
            username = jwtUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
    }
    catch (ExpiredJwtException e){
        Cookie loginCookie = new Cookie("LoginToken","");
		loginCookie.setMaxAge(0);  // Set cookie expiration time
		response.addCookie(loginCookie);
    }
        chain.doFilter(request, response);
    }

}
