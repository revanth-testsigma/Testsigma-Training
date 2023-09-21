package com.authentication.app.filter;

import com.authentication.app.jwt.JwtUtil;
import com.authentication.app.model.Accesstokens;
import com.authentication.app.service.DefaultUserService;
import com.authentication.app.service.TokenService;

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
import java.util.Date;

@Component
public class V1RequestFilter extends OncePerRequestFilter {

    @Autowired
    private DefaultUserService userDetailsService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        if (request.getRequestURI().matches("/v1(.*)")){
            return false;
        }else{
            return true;
        }
	}
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
            try {
                String jwt = null;
                String username = null;
                final String authorizationHeader = request.getHeader("Token");

                if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                    jwt = authorizationHeader.substring(7);
                }else{
                    sendErrorResponse(response, "Authorization token not found in header !");
                    return;
                }
                if (jwt != null) {
                    username = jwtUtil.extractUsername(jwt);
                }else{
                    sendErrorResponse(response, "Authorization token not found !");
                    return;
                }

                

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    
                    Accesstokens tokenUser = this.tokenService.findByName(username);
                    if (tokenUser == null){
                      sendErrorResponse(response, "user token not found !");
                      return;  
                    }
                    String[] IssueUsername = tokenUser.getName().split("_");

                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(IssueUsername[0]);

                    if (jwtUtil.validateToken(jwt, tokenUser.getName())) {

                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken
                                .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }else {
                        sendErrorResponse(response, "Invalid token sent !");
                        return;
                    }
        }else{
            sendErrorResponse(response, "Username not found in token !");
            return;
            }
    }
    catch (ExpiredJwtException e){
        sendErrorResponse(response, "Authentication token is expired !");
        return;
    }
    catch (Exception e) {
        sendErrorResponse(response, "Authentication error: " + e.getMessage());
        return;
    }
        chain.doFilter(request, response);
    }

    private void sendErrorResponse(HttpServletResponse response, String errorMessage) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"" + errorMessage + "\"}");
    }
}
