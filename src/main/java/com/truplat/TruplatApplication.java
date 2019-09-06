package com.truplat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class TruplatApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruplatApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TruplatApplication.class, args);
		LOGGER.info("Truplat started...");
	}
}


