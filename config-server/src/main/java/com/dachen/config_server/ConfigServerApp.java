package com.dachen.config_server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigServerApp.class).web(true).run(args);
	}
}
