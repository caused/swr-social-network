package io.gustavo.starwars.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gustavo.starwars.entity.Localization;
import io.gustavo.starwars.exceptions.RebelNotFoundException;
import io.gustavo.starwars.model.RebelModel;
import io.gustavo.starwars.service.RebelService;

@RestController
@RequestMapping("/api/v1/rebels")
@Validated
public class RebelController {
	
	private RebelService service;
	
	public RebelController(RebelService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<RebelModel> createRebel(@Valid @RequestBody RebelModel request){
		var rebelCreated = service.createRebel(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(rebelCreated);
	}
	
	@PatchMapping("/{rebelId}/localization")
	public ResponseEntity<RebelModel> updateLocalization(@PathVariable Long rebelId, @Valid @RequestBody Localization localization) throws RebelNotFoundException{
		var updatedRebel = this.service.updateRebelLocalization(rebelId, localization);
		
		return ResponseEntity.ok(updatedRebel);
	}

}
