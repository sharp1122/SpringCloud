package com.dachen.eureka_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dachen.eureka_ribbon.service.ComputeService;

@RestController
public class ConsumerController {
	
    @Autowired
    ComputeService computeService;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return computeService.add();
    }
}