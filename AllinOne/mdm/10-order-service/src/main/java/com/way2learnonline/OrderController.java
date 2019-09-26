package com.way2learnonline;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.way2learnonline.domain.Order;
import com.way2learnonline.domain.OrderStatus;
import com.way2learnonline.domain.OrderType;
import com.way2learnonline.domain.Product;
import com.way2learnonline.domain.Shipment;
import com.way2learnonline.domain.ShipmentType;

@RestController
public class OrderController {
	
	private int index = 0;
	
	@Autowired
	private Source source;

	@GetMapping
	public Order createOrder(String productName) {
		
		Order order = new Order(index++, OrderType.PURCHASE, LocalDateTime.now(), OrderStatus.NEW, new Product(productName), new Shipment(ShipmentType.SHIP));
		source.output().send(new GenericMessage(order));
		
		return order;
		
	}
	

}
