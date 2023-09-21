package com.ams.app.controller;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ams.app.model.Faculty;
import com.ams.app.model.Student;
import com.ams.app.service.FacultyService;
import com.ams.app.service.MyUserDetailsService;
import com.ams.app.service.StudentService;
import com.ams.app.util.JwtUtil;

@RestController
public class LoginController {
	
	@Autowired
	StudentService studentService;
    
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	JwtUtil util;

	@Autowired
	MyUserDetailsService userDetailsService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object Userdata(HttpServletResponse response) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		User user = (User) securityContext.getAuthentication().getPrincipal();
		String role = user.getAuthorities().stream().findFirst().get().getAuthority();
		if(role.equals("STUDENT")){
			Student s =  studentService.findByUsername(user.getUsername());
			UserDetails userDetails = userDetailsService.loadUserByUsername(s.getUsername());
            System.out.println("Login successful");
            final String jwt = util.generateToken(userDetails);
			s.setPassword(jwt);
			return s;
		}else if(role.equals("FACULTY")){
			Faculty f =  facultyService.findByUsername(user.getUsername());
			UserDetails userDetails = userDetailsService.loadUserByUsername(f.getUsername());
            System.out.println("Login successful");
            final String jwt = util.generateToken(userDetails);
			f.setPassword(jwt);
			return f;
		}
		return "Error occured";
}
}
