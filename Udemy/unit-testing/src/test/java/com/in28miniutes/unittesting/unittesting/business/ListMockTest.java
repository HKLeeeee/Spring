package com.in28miniutes.unittesting.unittesting.business;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
	List<String> mock = mock(List.class);

	@Test
	public void size_basic(){
		when(mock.size()).thenReturn(5);
		assertThat(mock.size()).isEqualTo(5);
	}

	@Test
	public void differentValue(){
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertThat(mock.size()).isEqualTo(5);
		assertThat(mock.size()).isEqualTo(10);
	}

	@Test
	public void returnWithParam(){
		when(mock.get(0)).thenReturn("test");
		assertThat(mock.get(0)).isEqualTo("test");
		assertThat(mock.get(1)).isNull();
	}

	@Test
	public void returnWithGenericParam(){
		when(mock.get(anyInt())).thenReturn("test"); // argumentMatchers
		assertThat(mock.get(0)).isEqualTo("test");
		assertThat(mock.get(1)).isEqualTo("test");
		assertThat(mock.get(100)).isEqualTo("test");
	}

	@Test
	public void verificationBasics() {
		// SUT
		String value = mock.get(0);
		String value1 = mock.get(1);

		// Verify
		verify(mock).get(0);
		// verify(mock).get(anyInt());
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, never()).get(2);
	}

	@Test
	public void argumentCapturing(){
		// SUT
		mock.add("Some");

		// Verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());

		assertThat(captor.getValue()).isEqualTo("Some");
	}

	@Test
	public void argumentCapturingMultiple(){
		// SUT
		mock.add("Some");
		mock.add("Some2");

		// Verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();
		assertThat(allValues.get(0)).isEqualTo("Some");
		assertThat(allValues.get(1)).isEqualTo("Some2");
	}
}
