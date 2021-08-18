package com.py.columbia.pr2.nildandrergio.springrestpaises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringRestPaisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestPaisesApplication.class, args);
	}

}
