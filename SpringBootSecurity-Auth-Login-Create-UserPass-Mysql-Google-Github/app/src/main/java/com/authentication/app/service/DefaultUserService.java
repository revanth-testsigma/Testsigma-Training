package com.authentication.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.authentication.app.dto.UserRegisteredDTO;
import com.authentication.app.model.User;


public interface DefaultUserService extends UserDetailsService{
	User save(UserRegisteredDTO userRegisteredDTO);
	User findByEmail(String email);
}
