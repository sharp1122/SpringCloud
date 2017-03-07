package com.dachen.eureka_ribbon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ComputeService.class.getName());
	
	@Autowired
	RestTemplate restTemplate;
	
//	@HystrixCommand(fallbackMethod="addFallback")
	public String add() {
		return get("http://COMPUTE-SERVICE/add?a=10&b=20");
	}
	
//	@HystrixCommand(fallbackMethod="addFallback")
	public String addPost(MultiValueMap<String, String> paramMap) {
		return post("http://COMPUTE-SERVICE/add", paramMap);
	}
	
//	@HystrixCommand(fallbackMethod="addFallback")
	public String json() {
		return post("http://COMPUTE-SERVICE/json", null);
	}
	
//	@HystrixCommand(fallbackMethod="addFallback")
	public String test() {
		return get("http://ACT_CONSOLE/act/test");
	}
	
	public String get(String url) {
		LOG.info("get......");
		return restTemplate.getForObject(url, String.class);
	}
	public String post(String url, MultiValueMap<String, String> paramMap) {
		LOG.info("post......");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<MultiValueMap<String, String>>(paramMap, headers);
		return restTemplate.postForObject(url, formEntity, String.class);
	}
	
	
	public String addFallback() {
		return "error";
	}
}
