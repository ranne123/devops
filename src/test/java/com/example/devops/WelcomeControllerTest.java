package com.example.devops;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@WebAppConfiguration

public class WelcomeControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;
	@InjectMocks
	private com.example.devops.web.WelcomeController welcomeController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(welcomeController).build(); // only this works
	}

	@Test
	public void testWelcome() throws Exception {

		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(model().attributeExists("course"))
				.andExpect(model().size(2)).andExpect(model().attribute("course", containsString("Devops")));
	}

}
