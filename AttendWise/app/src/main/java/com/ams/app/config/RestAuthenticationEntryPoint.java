package com.ams.app.config;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
  This entry point is called once the request missing their authentication.
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest arg0, HttpServletResponse arg1,
                       AuthenticationException arg2) throws IOException, ServletException {
    arg1.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

  }
}