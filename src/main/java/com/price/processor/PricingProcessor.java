package com.price.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.price.dao.PricingRepository;
import com.price.pojo.GenericResponse;
import com.price.pojo.PriceTable;
import com.price.util.PricingConstants;
import com.price.util.ResponseMsg;

@Component
public class PricingProcessor {

	@Autowired
	private PricingRepository repository;
	
	private static Gson gson ;
	
	@PostConstruct 
	public void initIt() throws Exception {
		gson = new Gson();
	}
	

	public GenericResponse<PriceTable> productGetPrice(Integer productId) {
		GenericResponse<PriceTable> response = new GenericResponse<PriceTable>();

		try {
			Optional<PriceTable> dbResponse = repository.findById(productId);
			if (dbResponse.isPresent()) {
				response.setResponseCode(HttpStatus.OK);
				response.setResponseMessage(ResponseMsg.SUCCESS.toString());
				response.setResponseBody(dbResponse.get());
			} else {
				response.setResponseCode(HttpStatus.NOT_ACCEPTABLE);
				response.setResponseMessage(ResponseMsg.FAILURE.toString());
				List<String> errors = new ArrayList<String>();
				errors.add(PricingConstants.ERROR_INVALID_PRODUCT_ID);
				response.setErrors(errors);
			}

		} catch (Exception e) {
			response.setResponseCode(HttpStatus.SERVICE_UNAVAILABLE);
			response.setResponseMessage(ResponseMsg.FAILURE.toString());
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			response.setErrors(errors);
		}

		return response;
	}

	public GenericResponse<PriceTable> productAddUpdatePrice(Integer productId, String priceInfo) {
		GenericResponse<PriceTable> response = new GenericResponse<PriceTable>();
		PriceTable req = gson.fromJson(priceInfo, PriceTable.class);
		req.setProductId(productId);
		try {
			PriceTable dbResponse = repository.save(req);

			response.setResponseCode(HttpStatus.OK);
			response.setResponseMessage(ResponseMsg.SUCCESS.toString());
			response.setResponseBody(dbResponse);

		} catch (Exception e) {
			response.setResponseCode(HttpStatus.SERVICE_UNAVAILABLE);
			response.setResponseMessage(ResponseMsg.FAILURE.toString());
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			response.setErrors(errors);
		}

		return response;
	}

}
