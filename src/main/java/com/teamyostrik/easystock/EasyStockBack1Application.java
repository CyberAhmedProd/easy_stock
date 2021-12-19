package com.teamyostrik.easystock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EasyStockBack1Application {

	public static void main(String[] args) {
		SpringApplication.run(EasyStockBack1Application.class, args);
	}

}
