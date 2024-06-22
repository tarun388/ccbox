package com.verma.tarun.ccbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CcboxApplication {

	private static final Logger log = LoggerFactory.getLogger(CcboxApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CcboxApplication.class, args);
	}

}
