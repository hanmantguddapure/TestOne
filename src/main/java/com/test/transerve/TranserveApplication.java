package com.test.transerve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.test")
@EnableJpaRepositories("com.test")
@EntityScan("com.test.transerve.entity")
public class TranserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranserveApplication.class, args);
	}

}
