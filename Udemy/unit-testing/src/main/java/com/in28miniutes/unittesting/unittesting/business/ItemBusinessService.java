package com.in28miniutes.unittesting.unittesting.business;

import org.springframework.stereotype.Service;

import com.in28miniutes.unittesting.unittesting.model.Item;

@Service
public class ItemBusinessService {

	public Item getItem(){
		Item item = new Item(1, "Ball", 20, 200);
		return item;
	}
}
