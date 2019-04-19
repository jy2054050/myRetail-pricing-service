package com.price.dao;

import org.springframework.data.repository.CrudRepository;

import com.price.pojo.PriceTable;

public interface PricingRepository extends CrudRepository<PriceTable, Integer> {
	
}
