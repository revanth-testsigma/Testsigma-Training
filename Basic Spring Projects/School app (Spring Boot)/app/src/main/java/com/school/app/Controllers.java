package com.school.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
@Controller
public class Controllers {

@GetMapping("/")
public String hello(){
	return "hello";
}

@PostMapping("/save")
public String save(){
	return "save";
}
}


