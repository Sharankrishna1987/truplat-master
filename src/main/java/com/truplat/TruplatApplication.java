package com.truplat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class TruplatApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruplatApplication.class, args);
	}
}


