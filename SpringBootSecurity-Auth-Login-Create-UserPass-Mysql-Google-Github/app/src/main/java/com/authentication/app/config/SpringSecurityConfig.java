package com.authentication.app.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.authentication.app.filter.LoginRequestFilter;
import com.authentication.app.filter.V1RequestFilter;
import com.authentication.app.service.DefaultUserService;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
    @Autowired
    private V1RequestFilter v1filter;

    @Autowired
    private LoginRequestFilter loginfilter;

	@Autowired
	private  DefaultUserService userDetailsService;

	@Autowired
	AuthenticationSuccessHandler successHandler;
    
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
    
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {    
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/registration/**","/login/**","/styles/**").permitAll()
        .antMatchers("/v1/**").authenticated()  // Require authentication for v1
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(loginfilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(v1filter, UsernamePasswordAuthenticationFilter.class)
        .formLogin().loginPage("/login").successHandler(successHandler)
        .and().csrf().disable()
        .logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("LoginToken")
        .and().oauth2Login().loginPage("/login").successHandler(successHandler)
        .and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

}
