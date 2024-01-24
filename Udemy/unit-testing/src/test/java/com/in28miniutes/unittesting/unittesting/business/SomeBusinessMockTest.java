package com.in28miniutes.unittesting.unittesting.business;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.in28miniutes.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessMockTest {

	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);

	public SomeBusinessMockTest() {
		business.setSomeDataService(dataServiceMock);
	}

	// @BeforeEach()
	// public void before(){
	//     business.setSomeDataService(dataServiceMock);
	// }

	@Test
	public void calculateSum_basic(){
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertThat(business.calculateSumUsingDataService()).isEqualTo(6);
	}

	@Test
	public void calculateSum_empty(){
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertThat( business.calculateSumUsingDataService()).isEqualTo(0);
	}

	@Test
	public void calculateSum_one(){
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1});
		assertThat(business.calculateSumUsingDataService()).isEqualTo(1);
	}
}
