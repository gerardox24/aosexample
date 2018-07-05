package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class AppexamenfinalApplication {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppexamenfinalApplication.class, args);
	}
}
