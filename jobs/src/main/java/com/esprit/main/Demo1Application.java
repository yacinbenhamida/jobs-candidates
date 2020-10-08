package com.esprit.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.esprit.models.Job;

@SpringBootApplication
@ComponentScan("com.esprit")
@EntityScan(basePackages = {"com.esprit.models"})
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	@Autowired
	private JobRepository repository;
	@Bean
	ApplicationRunner init() {
		return args -> {
			repository.save(new Job("Développeur full stack java",true));
			repository.save(new Job("Développeur full stack NODEJS",true));
			repository.save(new Job("Développeur SYMFONY ",false));
		};
	}

}
