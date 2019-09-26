package com.way2learnonline;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class OauthClientApplication {

	@Autowired
	private OAuth2RestTemplate restTemplate;
	
	
	// TODO-1 Configure ResourceOwnerPasswordResourceDetails by uncommenting below method 
/*
	@Bean 
	protected OAuth2ProtectedResourceDetails resource(){
		ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
		details.setAccessTokenUri("http://localhost:8080/oauth/token");
		details.setClientId("way2learn");
		details.setClientSecret("way2learn");
		details.setGrantType("password");
		return details;
	}
	*/
	// TODO-2 Configure OAuth2RestTemplate by uncommenting below method
	
/*	@Bean
	public OAuth2RestTemplate restTemplate(){
		DefaultOAuth2ClientContext oAuth2ClientContext=new DefaultOAuth2ClientContext();
		
		AccessTokenRequest accessTokenRequest=oAuth2ClientContext.getAccessTokenRequest();		
		accessTokenRequest.set("username", "admin");
		accessTokenRequest.set("password", "admin");
		
		
		return new OAuth2RestTemplate(resource(), oAuth2ClientContext);
		
		
	}*/
	
	@RequestMapping("/clienthello")
	public String execute() throws URISyntaxException{		
			
		return restTemplate.getForObject("http://localhost:8080/hello", String.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(OauthClientApplication.class, args);
	}
}
