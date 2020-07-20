package com.inventory.mini.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(auth);
		
		UserBuilder users= User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(users.username("player").password("admin").roles("PLAYER"))
		.withUser(users.username("watcher").password("other").roles("WATCHER"));
		
		
		
	}

	
	
}
