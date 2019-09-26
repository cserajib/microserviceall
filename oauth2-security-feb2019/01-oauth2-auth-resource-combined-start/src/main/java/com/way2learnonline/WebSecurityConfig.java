package com.way2learnonline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

// TODO -3 Make this class to extend WebSecurityConfigurerAdapter
public class WebSecurityConfig  {
	
	//TODO-4 configure authentication Manager bean by uncommenting the below code

/*	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}*/

	
	
	// TODO-5 configure Authentication manager builer with  inmemory authentication  by uncommenting below code
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("siva").password("siva").roles("USER").and()
		.withUser("admin").password("admin").roles("ADMIN");
	}
	*/
	// TODO-6 disable csrf by uncommenting below code
/*	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}
	*/
}
