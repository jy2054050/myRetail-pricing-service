package com.price.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.price.pojo.GenericResponse;
import com.price.pojo.PriceTable;
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
	public GenericResponse<PriceTable> getPrice(@PathVariable Integer productId) {
		return pricingProcessor.productGetPrice(productId);
	}
	
	@RequestMapping(value="/product/{productId}/price", method = RequestMethod.POST)
	public GenericResponse<PriceTable> addPrice(@PathVariable Integer productId,@RequestBody String priceInfo) {
		return pricingProcessor.productAddUpdatePrice(productId, priceInfo);
	}
	
	@RequestMapping(value="/product/{productId}/price", method = RequestMethod.PUT)
	public GenericResponse<PriceTable> updatePrice(@PathVariable Integer productId, @RequestBody String priceInfo) {
		return pricingProcessor.productAddUpdatePrice(productId, priceInfo);
	}
	
	
}
