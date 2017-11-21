package com.spring.security.oauth.config;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

	@GetMapping("/principal")
	public Principal user(Principal principal) {
		return principal;
	}
	public String hello() {
		return "Hello World";
	}
}
