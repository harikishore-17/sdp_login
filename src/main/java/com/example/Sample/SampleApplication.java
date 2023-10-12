package com.example.Sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {
	public static void main(String[] args) {
		/*
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 System.out.println(passwordEncoder.encode("pass"));
		*/
		SpringApplication.run(SampleApplication.class, args);
	}
}
