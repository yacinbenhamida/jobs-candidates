package com.example.demo;

import java.util.stream.Stream;
import com.example.demo.CandidatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.esprit.models.Candidat;

@SpringBootApplication
@ComponentScan("com")
@EntityScan(basePackages = {"com.esprit.models"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	private CandidatRepository repository;
	@Bean
	ApplicationRunner init() {
		return args -> {
			repository.save(new Candidat("ahmed"));
			repository.save(new Candidat("Salma"));
			repository.save(new Candidat("karima"));
			repository.findAll().forEach(System.out::println);
		};
	}

}
