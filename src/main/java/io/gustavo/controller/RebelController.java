package io.gustavo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rebels")
public class RebelController {
	
	@GetMapping
	public ResponseEntity<String> hello(){
		return ResponseEntity.ok("Hello");
	}

}
