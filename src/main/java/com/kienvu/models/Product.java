package com.kienvu.models;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
	private int id;
	private String product_name;
	private String product_describe;
	private String image;
	private BigDecimal price;
	private boolean product_status;
	private String create_at;
	
	public Product() {}
	public Product(int id, String product_name, String product_describe, String image, BigDecimal price, boolean product_status, String create_at) {
		this.id =id;
		this.product_name=product_name;
		this.product_describe=product_describe;
		this.image=image;
		this.price=price;
		this.product_status=product_status;
		this.create_at=create_at;
	}
	
	//
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_describe(String desc) {
		this.product_describe=desc;
	}
	public String getProduct_describe() {
		return product_describe;
	}
	public void setImage(String img) {
		this.image =img;
	}
	public String getImage() {
		return image;
	}
	public void setProduct_status(boolean status) {
		this.product_status= status;
	}
	public boolean getProduct_status() {
		return product_status;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public String getCreate_at() {
		return create_at;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

}
