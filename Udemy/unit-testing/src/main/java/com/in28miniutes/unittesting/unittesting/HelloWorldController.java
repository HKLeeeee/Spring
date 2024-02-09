package com.in28miniutes.unittesting.unittesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28miniutes.unittesting.model.Item;
import com.in28miniutes.unittesting.unittesting.business.ItemBusinessService;

@RestController
public class HelloWorldController {
	final ItemBusinessService businessService;

	public HelloWorldController(ItemBusinessService businessService) {
		this.businessService = businessService;
	}

	@GetMapping()
	public String helloWorld(){
		return "Hello";
	}

	@GetMapping("/dummy-item")
	public Item item() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/item-from-service")
	public Item itemFromService() {
		return businessService.getItem();
	}
}
