package com.price.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.price.dao.PricingRepository;

@Component
public class PricingProcessor {

	@Autowired
	private PricingRepository repository;
	
	public String productPrice(Integer pId){
		return repository.findByProductId(pId).toString();
	}
	
}
