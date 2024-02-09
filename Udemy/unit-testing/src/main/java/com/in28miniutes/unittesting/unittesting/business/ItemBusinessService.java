package com.in28miniutes.unittesting.unittesting.business;

import org.springframework.stereotype.Service;

import com.in28miniutes.unittesting.model.Item;

@Service
public class ItemBusinessService {

	public Item getItem(){
		return new Item(1, "Ball", 20, 200);
	}
}
