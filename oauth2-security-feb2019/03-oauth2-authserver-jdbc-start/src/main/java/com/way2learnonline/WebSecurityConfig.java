package com.way2learnonline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("siva").password("siva").roles("USER").and()
		.withUser("admin").password("admin").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		
		http.csrf().disable().authorizeRequests().anyRequest().authenticated()
		.antMatchers("/oauth/*").permitAll();
	}
	
}
