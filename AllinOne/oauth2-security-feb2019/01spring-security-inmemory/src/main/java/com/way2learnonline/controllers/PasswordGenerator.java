package com.way2learnonline.controllers;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		StandardPasswordEncoder passwordEncoder= new StandardPasswordEncoder();
		String encodePassword=passwordEncoder.encode("secret");
		System.out.println("Encoded Password is "+encodePassword);

	}

}
