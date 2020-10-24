package com.comulynx.wallet.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication 
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

	// TODO : Add BCryptPasswordEncoder bean here
	//Addded BCryptPasswordEncoder
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
