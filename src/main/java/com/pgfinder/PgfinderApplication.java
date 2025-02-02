package com.pgfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.pgfinder.controller", "com.pgfinder.service" })
@EntityScan(basePackages = { "com.pgfinder.entity" })
@EnableJpaRepositories(basePackages = { "com.pgfinder.repo" })
public class PgfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgfinderApplication.class, args);
	}

}
