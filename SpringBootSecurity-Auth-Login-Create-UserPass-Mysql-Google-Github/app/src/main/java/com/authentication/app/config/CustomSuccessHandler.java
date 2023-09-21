package com.authentication.app.config;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.authentication.app.dto.UserRegisteredDTO;
import com.authentication.app.jwt.JwtUtil;
import com.authentication.app.service.DefaultUserService;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	DefaultUserService userService;
		
	@Autowired
	JwtUtil jwtTokenUtil;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String username = null;
		if(authentication.getPrincipal() instanceof DefaultOAuth2User) {
			DefaultOAuth2User  userDetails = (DefaultOAuth2User) authentication.getPrincipal();
			username = userDetails.getAttribute("email") !=null?userDetails.getAttribute("email"):userDetails.getAttribute("login")+"@gmail.com" ;
			
		 if(userService.findByEmail(username) == null) {
        	  UserRegisteredDTO user = new UserRegisteredDTO(userDetails.getAttribute("email") !=null?userDetails.getAttribute("email"):userDetails.getAttribute("login"),username,("Dummy"),"USER");
        	  userService.save(user);
          }

		}else{
			username =  ((UserDetails) authentication.getPrincipal()).getUsername();
		}

		final UserDetails userDe = userService.loadUserByUsername(username);

		final String login = jwtTokenUtil.generateToken(userDe, new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 1L));
		Cookie loginCookie = new Cookie("LoginToken", login);
		loginCookie.setMaxAge(86400 * 1);  // Set cookie expiration time
		loginCookie.setPath("/");
		response.addCookie(loginCookie);  
		String redirectUrl = "/dashboard";
		
		
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

}
