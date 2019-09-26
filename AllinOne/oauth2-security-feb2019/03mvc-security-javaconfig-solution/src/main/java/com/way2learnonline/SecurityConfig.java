package com.way2learnonline;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		
		
		
		auth.inMemoryAuthentication()
			//.passwordEncoder(new ShaPasswordEncoder())
			.withUser("siva").password("secret").roles("ADMIN")
			.and()
			.withUser("prasad").password("secret").roles("USER");			
	}
	

	
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
					.antMatchers("/login**").permitAll()
					.antMatchers("/x/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				.and()
					.formLogin()
						.loginPage("/login").usernameParameter("myusername")
						.passwordParameter("mypassword").loginProcessingUrl("/mylogin")
						.failureUrl("/login?error")
				.and()
					.logout().logoutUrl("/logout");
					//.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));			
		
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
	
}
