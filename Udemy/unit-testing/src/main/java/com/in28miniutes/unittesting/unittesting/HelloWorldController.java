package com.in28miniutes.unittesting.unittesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28miniutes.unittesting.unittesting.model.Item;
import com.in28miniutes.unittesting.unittesting.business.ItemBusinessService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {
	private ItemBusinessService businessService;
	public HelloWorldController(ItemBusinessService businessService) {
		this.businessService = businessService;
	}

	@GetMapping()
	public String helloWorld(){
		return "Hello";
	}

	@GetMapping("/dummy-item")

	public Item item() {
		Item item = new Item(1, "Ball", 10, 100);
		return item;
	}

	@GetMapping("/item-from-service")
	public Item itemFromService() {
		return businessService.getItem();
	}
}
