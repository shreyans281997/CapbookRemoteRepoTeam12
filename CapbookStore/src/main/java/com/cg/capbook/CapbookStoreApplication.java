package com.cg.capbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@SpringBootApplication(scanBasePackages= {"com.cg.capbook"})
@EntityScan(basePackages="com.cg.capbook.model")
@EnableJpaRepositories(basePackages="com.cg.capbook.daoservice")
@EnableWebMvc
public class CapbookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapbookStoreApplication.class, args);
	}

}
