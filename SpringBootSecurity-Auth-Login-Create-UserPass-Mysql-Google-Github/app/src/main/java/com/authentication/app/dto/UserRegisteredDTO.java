package com.authentication.app.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisteredDTO {

    private String name;
	
	private String email;
	
	private String password;
	
	private List<GrantedAuthority> role;
	public UserRegisteredDTO(){
		
	}
	public UserRegisteredDTO(String name, String email, String password, String role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = Arrays.stream(role.split(","))
		.map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());;
	}
	
	
}
