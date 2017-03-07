package com.dachen.compute.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
public class ComputeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private DiscoveryClient client;
    
    @Autowired
    RestTemplate restTemplate;
    
    @ApiOperation(value="求和", notes="求两数之和")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="a", value="加数a", required=true, paramType="query", dataType="Integer"),
    	@ApiImplicitParam(name="b", value="加数b", required=true, paramType="query", dataType="Integer")
    })
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		System.out.println("++++++++++++++++++++++++");
		return restTemplate.getForEntity("http://ACT-CONSOLE/act/test", String.class).getBody();
	}
	
	
	
}