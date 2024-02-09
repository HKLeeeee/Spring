package com.in28miniutes.unittesting.unittesting;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void helloWorld_basic() throws Exception{
		// call "/"
		RequestBuilder request = MockMvcRequestBuilders
			.get("/")
			.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string("Hello"))
			.andReturn();
		// verify "Hello"
		// assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("Hello");
	}

	@Test
	public void dummyItem_basic() throws Exception{
		// call "/"
		RequestBuilder request = MockMvcRequestBuilders
			.get("/dummy-item")
			.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\": 1 , \"name\": \"Ball\", \"price\": 10, \"quantity\": 100}"))
			.andReturn();

	}
}
