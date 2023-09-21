// package com.authentication.app.config;

// import java.io.IOException;

// import javax.servlet.ServletException;
// import javax.servlet.http.Cookie;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.springframework.security.core.Authentication;
// import org.springframework.security.web.DefaultRedirectStrategy;
// import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
// import org.springframework.stereotype.Component;

// @Component
// public class CustomLogoutSuccessHandler implements  LogoutSuccessHandler{

//     @Override
//     public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//             throws IOException, ServletException {
//                 Cookie[] cookies = request.getCookies();
//                 if (cookies != null) {
//                     for (Cookie cookie : cookies) {
//                         if ("LoginToken".equals(cookie.getName())) {
//                             // Set the cookie's expiry time to the past
//                             cookie.setMaxAge(0);  // This effectively deletes the cookie
//                             cookie.setPath("/");  // Set the same path as when the cookie was set
//                             response.addCookie(cookie);
//                             break;  // No need to check other cookies
//                         }
//                     }
//                 }
//                 String redirectUrl = "/dashboard";
//                 new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
//     }
    
// }
