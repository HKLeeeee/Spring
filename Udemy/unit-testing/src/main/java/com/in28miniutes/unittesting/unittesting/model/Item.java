package com.in28miniutes.unittesting.unittesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Item")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
	@Id
	private Integer id;
	private String name;
	private int price;
	private int quantity;

	@Transient
	private int value;

	public Item(Integer id, String name, int price, int quantity){
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String toString(){
		return String.format("Item[%d %s %d %d]", id, name, price, quantity);
	}
}
