package com.optum.configserverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigserverapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverapiApplication.class, args);
	}

}
