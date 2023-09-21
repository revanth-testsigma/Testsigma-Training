package com.authentication.app.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.authentication.app.dao.UserRepository;
import com.authentication.app.dto.UserRegisteredDTO;

import com.authentication.app.model.User;


@Service
public class DefaultUserServiceImpl implements DefaultUserService{
   @Autowired
	private UserRepository userRepo;
  	
   
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		User user = userRepo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String roles){
		List<GrantedAuthority> rol = Arrays.stream(roles.split(","))
		.map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());
		return rol;
	}

	@Override
	public User save(UserRegisteredDTO userRegisteredDTO) {
		
		User user = new User();
		user.setEmail(userRegisteredDTO.getEmail());
		user.setName(userRegisteredDTO.getName());
		user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
		user.setRoles("USER");
		
		return userRepo.save(user);
	}
	public User findByEmail(String email){
		return userRepo.findByEmail(email);
	}
}
