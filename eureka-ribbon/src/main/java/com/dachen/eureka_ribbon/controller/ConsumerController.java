package com.dachen.eureka_ribbon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dachen.eureka_ribbon.service.ComputeService;

@RestController
public class ConsumerController {

	private static final Logger LOG = LoggerFactory.getLogger(ConsumerController.class.getName());

	@Autowired
	ComputeService computeService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return computeService.add();
		
//		MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<String, String>();
//		paramMap.add("a", 11 + "");
//		paramMap.add("b", 22 + "");
//
//		return computeService.addPost(paramMap);

//		return computeService.addPostJson("{\"a\":11,\"b\":33}");
		
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public String json() {
		return computeService.json();
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return computeService.test();
	}

	@RequestMapping("/home")
	public String home() {
		LOG.info("you called home");
		return "Hello World";
	}
}