package com.way2learnonline;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private OAuth2RestTemplate oauth2RestTemplate;


    @RequestMapping("/user")
    public Principal user(Principal principal) throws Exception {
        System.out.println(principal);
        
        URI uri = new URI("http://localhost:7070/resource/hello");
		RequestEntity<String> request = new RequestEntity<String>(HttpMethod.GET, uri);		
		String response=oauth2RestTemplate.exchange(request, String.class).getBody();
		
		System.err.println(response);

       /* System.out.println(clientContext);
        System.out.println(protectedResourceDetails);
        */
        return principal;
    }
}
