package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.RestApis;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableAutoConfiguration
public class ProjectFrogChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectFrogChallengeApplication.class, args);
	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProjectFrogChallengeApplication.class);
	}
}
