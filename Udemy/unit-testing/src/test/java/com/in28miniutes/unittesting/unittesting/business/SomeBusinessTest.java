package com.in28miniutes.unittesting.unittesting.business;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SomeBusinessTest {

	@Autowired
	private SomeBusinessImpl business;
	@Test
	public void calculateSum_basic(){
		int result = business.calculateSum(new int[] {1,2,3});
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void calculateSum_empty(){
		int result = business.calculateSum(new int[] {});
		assertThat(result).isEqualTo(0);
	}
}
