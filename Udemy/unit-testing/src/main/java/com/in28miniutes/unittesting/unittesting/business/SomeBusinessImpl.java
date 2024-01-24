package com.in28miniutes.unittesting.unittesting.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.in28miniutes.unittesting.unittesting.data.SomeDataService;

@Service
public class SomeBusinessImpl {

	private SomeDataService someDataService;

	public int calculateSum(int[] data){
		int sum = 0;
		for(int value: data){
			sum += value;
		}
		return sum;
	}

	public int calculateSumUsingDataService(){
		int sum = 0;
		int[] data = someDataService.retrieveAllData();
		for(int value: data){
			sum += value;
		}
		return sum;
	}
}
