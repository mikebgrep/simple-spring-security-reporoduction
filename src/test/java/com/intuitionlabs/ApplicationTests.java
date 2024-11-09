package com.intuitionlabs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuitionlabs.model.LoginDto;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	MockMvc mvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void works() throws Exception {
		LoginDto loginDto = new LoginDto("user", "password");

		this.mvc.perform(post("/accounts").contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsBytes(loginDto)))
				.andExpect(status().isOk());

		MockHttpServletResponse response = this.mvc.perform(post("/auth/login").contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsBytes(loginDto)))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse();

		String accessToken = JsonPath.read(response.getContentAsString(), "$.accessToken");
		this.mvc.perform(get("/user/me").header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk());
	}

}
