package com.way2learnonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.context.request.RequestContextListener;

@EnableOAuth2Sso
@SpringBootApplication

public class UiApplication extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/login**")
            .permitAll()
            .anyRequest()
            .authenticated();
    }
    
	@Autowired
	private OAuth2ClientContext clientContext;
	
	@Autowired
	private OAuth2ProtectedResourceDetails protectedResourceDetails;
	
	@Bean
	public OAuth2RestTemplate restTemplate() {
		return new OAuth2RestTemplate(protectedResourceDetails, clientContext);
	}

    
  /* @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
*/
   
    
    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }
}