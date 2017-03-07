package com.dachen.compute;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ComputeApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ComputeApp.class).web(true).run(args);
	}
}
