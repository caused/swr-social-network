package io.gustavo.starwars.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gustavo.starwars.model.request.CreateRebelRequest;
import io.gustavo.starwars.model.response.CreateRebelResponse;

@RestController
@RequestMapping("/api/v1/rebels")
public class RebelController {
	
	@GetMapping
	public ResponseEntity<String> hello(){
		return ResponseEntity.ok("Hello");
	}
	
	@PostMapping
	public ResponseEntity<CreateRebelResponse> createRebel(@Valid CreateRebelRequest request){
		System.out.println(request);
		return ResponseEntity.ok(new CreateRebelResponse());
	}

}
