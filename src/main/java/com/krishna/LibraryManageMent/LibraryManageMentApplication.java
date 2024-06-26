package com.krishna.LibraryManageMent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManageMentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManageMentApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return runner -> {
			System.out.println("Hello world..............");
		};
	}

}
