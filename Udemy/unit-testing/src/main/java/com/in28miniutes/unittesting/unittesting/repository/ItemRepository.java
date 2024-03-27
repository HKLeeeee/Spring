package com.in28miniutes.unittesting.unittesting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28miniutes.unittesting.unittesting.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	public Optional<Item> findById(Integer id);
}
