package com.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
public class TutorialManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialManagementApplication.class, args);
	}

}
