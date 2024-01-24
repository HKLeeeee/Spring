package com.in28miniutes.unittesting.unittesting.data;

import org.springframework.stereotype.Service;

public interface SomeDataService {

	public int[] retrieveAllData();

	// public int returnOneData();
	/*
	If you are using JUnit 5, in the next lecture use
	@ExtendWith(MockitoExtension.class)
	instead of @RunWith(MockitoJUnitRunner.class)
	 */
}
