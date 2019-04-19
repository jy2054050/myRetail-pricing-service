package com.price.dao;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.price.pojo.PriceTable;

public interface PricingRepository extends CrudRepository<PriceTable, Integer> {

	@Query("Select * from price where productid=?0")
	PriceTable findByProductId(Integer productId);
	
	
}
