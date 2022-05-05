package com.broadfactor.api.common;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Singletons {

	private static RestTemplate restTemplate;
	private static ObjectMapper mapper;
	
	private Singletons() {
	    throw new IllegalStateException("Utility class");
	}
	
	
	public static RestTemplate restTemplate() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		return restTemplate;
	}

	public static ObjectMapper instanceMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
		}
		return mapper;
	}
}
