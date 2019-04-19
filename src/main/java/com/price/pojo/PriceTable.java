package com.price.pojo;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("price")
public class PriceTable {

	@PrimaryKey("productid")
	private Integer productId;

	@Column("price")
	private Double price;

	@Column("currency")
	private String currency;

	public PriceTable(final Integer productId ,final Double price, final String currency ){
		this.productId= productId;
		this.price = price;
		this.currency = currency;
		
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Price [productId=" + productId + ", price=" + price + ", currency=" + currency + "]";
	}

}
