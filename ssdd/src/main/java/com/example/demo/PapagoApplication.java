package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication

//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class PapagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PapagoApplication.class, args);
	}

}
