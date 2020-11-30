package com.kr.connected;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kr.connected.util.Constants;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConnectionServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ConnectionServiceControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).dispatchOptions(true).build();
	}

	@Test
	public void test_when_Connection_exist() throws Exception {
		assertThatConnectionExist("Philadelphia", "Newark", "yes");
		assertThatConnectionExist("Philadelphia", "Boston", "yes");
	}

	@Test
	public void test_when_Connection_not_exist() throws Exception {
		assertThatConnectionExist("Boston", "Albany", "no");
	}

	public void assertThatConnectionExist(String origin, String destination, String connectionExist) throws Exception {
		this.mockMvc.perform(get(Constants.ENDPOINT)
				.param("origin", origin)
				.param("destination", destination))
		.andExpect(status().isOk())
		.andExpect(content().string(connectionExist));
	}

}
