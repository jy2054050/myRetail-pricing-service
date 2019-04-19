package com.price.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.price.processor.PricingProcessor;

@RestController
@RequestMapping("pricing")
public class PricingService {

	@Autowired
	private PricingProcessor pricingProcessor;

	@RequestMapping(value="/ping", method = RequestMethod.GET)
	public String ping() {
		return "Service is up !!";
	}
	
	@RequestMapping(value="/product/{productId}/price", method = RequestMethod.GET)
	public String getPrice(@PathVariable Integer productId) {
		return pricingProcessor.productPrice(productId);
	}
	
	@RequestMapping(value="/product/{productId}/price", method = RequestMethod.POST)
	public String addPrice(@PathVariable Integer productId) {
		return "Service is up !!";
	}
	
	@RequestMapping(value="/product/{productId}/price", method = RequestMethod.PUT)
	public String updatePrice(@PathVariable Integer productId) {
		return "Service is up !!";
	}
	
	
}
