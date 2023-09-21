package com.rev.revanth;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/user")
	public User user(@RequestParam(value = "name", defaultValue = "Rev") String name) {
		return new User(counter.incrementAndGet(), String.format(template, name));
	}
}