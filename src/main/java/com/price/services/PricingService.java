package com.price.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*",maxAge = 4800) 
public class PricingService {


	@RequestMapping(value="/ping", method = RequestMethod.GET)
	public String ping() {
		return "Service is up !!";
	}
}
