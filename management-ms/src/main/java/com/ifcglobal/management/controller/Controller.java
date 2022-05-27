package com.ifcglobal.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/management")
public class Controller {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public ResponseEntity<String> greet(){
		logger.info("inside greet");
		String s = "";
		try {
			//s = restTemplate.getForObject("http://ORDER-SERVICE/order/", String.class);
			//s = restTemplate.exchange("http://"+ serviceHost +"/class", HttpMethod.GET, null,new ParameterizedTypeReference<String>() {});
			s = restTemplate.exchange("http://ORDER-SERVICE/order/", HttpMethod.GET, null,
					new ParameterizedTypeReference<String>() {
					}).getBody();
		} catch (Exception e) {
			logger.error("e: " + e);
		}
		return ResponseEntity.ok("s: " + s);
	}
	
}
