package com.way2learnonline;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.way2learnonline.domain.*;


@Service
public class ProductService {
	
	private List<Product> products;
	
	public ProductService() {
		products = new ArrayList<>();
		products.add(new Product(1, "p1", 500));
		products.add(new Product(2, "p2", 100));
		products.add(new Product(3, "p3", 1000));
		products.add(new Product(4, "p4", 200));
	}
	
	public Product processOrder(Order order) {
		return products.stream().filter(p -> p.getName().equals(order.getProduct().getName())).findAny().get();
	}

}
