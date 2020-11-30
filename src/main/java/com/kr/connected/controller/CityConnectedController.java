package com.kr.connected.controller;

import static com.kr.connected.util.Constants.ENDPOINT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("/")
@Api(value = "CityConnected")
public class CityConnectedController {
 private static final Logger logger = LoggerFactory.getLogger(CityConnectedController.class);
 
	@GetMapping(ENDPOINT)
	@ApiOperation(value="Get the City connection Info")
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = " City connection found not found" , response = Boolean.class)
	})
	public Boolean connectionExist(@RequestParam String origin, @RequestParam String destination) {
		logger.debug(String.format("Connection input -> %s : %s", origin,destination));
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}
	
}
