package com.simple.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// We need the following in order to detect the filter
// from the security package
@ServletComponentScan(value="com.simple.jwt.security")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SimpleJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleJwtApplication.class, args);
	}
}
