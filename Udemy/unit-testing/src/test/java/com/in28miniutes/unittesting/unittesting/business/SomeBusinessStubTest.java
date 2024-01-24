package com.in28miniutes.unittesting.unittesting.business;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28miniutes.unittesting.unittesting.data.SomeDataService;
class SomeDataServiceStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

class SomeDataEmptyStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

class SomeDataOneStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {1};
	}
}
public class SomeBusinessStubTest {

	@Test
	public void calculateSum_basic(){
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int result = business.calculateSumUsingDataService();
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void calculateSum_empty(){
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataEmptyStub());
		int result = business.calculateSumUsingDataService();
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void calculateSum_one(){
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataOneStub());
		int result = business.calculateSumUsingDataService();
		assertThat(result).isEqualTo(1);
	}
}
