package com.kr.connected.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.kr.connected.model.CityEdge;

/**
 * Holds the {@link CityGraph} and the search algorithm processing the directed graph.
 */
@Service
public class CityConnectionService {

	private static final Logger logger = LoggerFactory.getLogger(CityConnectionService.class);

	@Autowired
	private CityGraph cityGraph;
	
	/**
	 * Load the input city data at startup.
	 * @param cityGraphFile
	 */
	@Autowired
	public void CityConnectionFinder(@Value("${path-finder.graph.file}") String cityGraphFile) {
		Stream<String> cities;
		logger.info("Using city graph file {}", cityGraphFile);
		try {
			ClassPathResource classPathResource = new ClassPathResource(cityGraphFile);
			cities = new BufferedReader(
					new InputStreamReader(classPathResource.getInputStream(), StandardCharsets.UTF_8))
					.lines();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		cities.forEach(line -> {
			String[] vertices = line.split(",");
			if (vertices.length == 2) {
				String origin = vertices[0].trim();
				String dest = vertices[1].trim();
				if(Strings.isBlank(origin) ||Strings.isBlank(dest)) {
					throw new IllegalArgumentException("Origin or Destination  can't be null");
				}
				cityGraph.addVertex(origin);
				cityGraph.addVertex(dest);
				cityGraph.addEdge(origin, dest);
			} else {
				throw new IllegalArgumentException("Illegal file format");
			}
		});
		
	}
	/**
	 * Find the connection between the city
	 * @param fromCity
	 * @param toCity
	 * @return
	 */
	public boolean findConnection(String origin, String dest) {
		return cityGraph.traverseNode(new CityEdge(origin, dest));
	}
}
