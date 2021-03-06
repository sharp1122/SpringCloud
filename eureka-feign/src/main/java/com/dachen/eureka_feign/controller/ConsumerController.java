package com.dachen.eureka_feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dachen.eureka_feign.i.ComputeClient;

@RestController
public class ConsumerController {

	@Autowired
    ComputeClient computeClient;
    
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(int a, int b) {
        return computeClient.add(a, b);
    }
	
	@RequestMapping(value = "/sum", method = RequestMethod.GET)
    public Integer sum() {
        return computeClient.add(20, 30);
    }
}
