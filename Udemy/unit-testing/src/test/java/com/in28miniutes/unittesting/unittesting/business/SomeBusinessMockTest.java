package com.in28miniutes.unittesting.unittesting.business;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28miniutes.unittesting.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business;
	@Mock
	SomeDataService dataServiceMock;

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
