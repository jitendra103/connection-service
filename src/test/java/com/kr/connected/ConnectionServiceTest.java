package com.kr.connected;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.ActiveProfiles;

import com.kr.connected.service.CityConnectionService;
import com.kr.connected.service.CityGraph;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class ConnectionServiceTest {
	
	private static final String fileName ="city.txt";
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@InjectMocks
	CityConnectionService service;
	
	CityGraph cityGraph;
	
	@Before
	public void setup() {
		cityGraph = new CityGraph();
		service.setCityGraph(cityGraph);
		cityGraph.addVertex("Boston");
		cityGraph.addVertex("New York");
		cityGraph.addEdge("Boston", "New York");
	}
	
	@Test
	public void test_when_Invalid_file_Format() {
		try {
			service.CityConnectionFinder(fileName);
		} catch(Exception e) {
				assertNotNull(e);
		}
	}
	
	@Test
	public void test_when_connection_exist() {
		
		assertEquals(service.findConnection("Boston", "New York"),"yes");
		
	}
	
	@Test
	public void test_when_connection_doesNotexist() {
		
		assertEquals(service.findConnection("Boston", "Nework"),"no");
		
	}
}
