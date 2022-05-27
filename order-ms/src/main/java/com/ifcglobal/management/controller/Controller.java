package com.ifcglobal.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class Controller {

	@GetMapping("/")
	public ResponseEntity<String> greet(){
		return ResponseEntity.ok("Hello from order service");
	}
	
}
