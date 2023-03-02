package com.example.dbdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class DbdemoApplication {
	private static final Log LOGGER = LogFactory.getLog(DbdemoApplication.class);
	public static void main(String[] args) {
		LOGGER.info("---DbDemoApplication bootstraped-----");
		SpringApplication.run(DbdemoApplication.class, args);
	}

}
