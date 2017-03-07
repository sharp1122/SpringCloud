package com.dachen.zipkin_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinController {

	@RequestMapping("/hello")
	public String hell() {
		return "Hello World";
	}
}
