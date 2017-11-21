package com.spring.security.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.requestMatchers().antMatchers("/login", "/oauth/authorize").
					and().authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.parentAuthenticationManager(authenticationManager).inMemoryAuthentication().withUser("Chetan")
				.password("Patel").roles("USER").and().withUser("Dhara").password("Patel").roles("ADMIN");
	}
}
