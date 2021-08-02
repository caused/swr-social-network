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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/rebels")
@Validated
public class RebelController {
	
	private RebelService service;
	
	public RebelController(RebelService service) {
		this.service = service;
	}
	
	@ApiOperation(value = "Cria um novo rebelde", notes = "Cria um novo rebelde", response = RebelModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Rebelde criado com sucesso"),
			@ApiResponse(code = 400, message = "Item de invetário não encontrado")
	})
	@PostMapping
	public ResponseEntity<RebelModel> createRebel(@Valid @RequestBody RebelModel request){
		var rebelCreated = service.createRebel(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(rebelCreated);
	}
	
	@ApiOperation(value = "Atualiza localização de um rebelde", notes = "Atualiza localização de um rebelde", response = RebelModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Localização atualizada com sucesso"),
			@ApiResponse(code = 404, message = "Rebelde não encontrado")
	})
	@PatchMapping("/{rebelId}/localization")
	public ResponseEntity<RebelModel> updateLocalization(@PathVariable Long rebelId, @Valid @RequestBody Localization localization) throws RebelNotFoundException{
		var updatedRebel = this.service.updateRebelLocalization(rebelId, localization);
		
		return ResponseEntity.ok(updatedRebel);
	}
	
	@ApiOperation(value = "Acusar um rebelde de traição", notes = "Acusar um rebelde de traição", response = RebelModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Rebelde acusasdo com sucesso"),
			@ApiResponse(code = 404, message = "Rebelde não encontrado")
	})
	@PatchMapping("/{rebelId}/blame")
	public ResponseEntity<RebelModel> blameRebel(@PathVariable Long rebelId) throws RebelNotFoundException{
		var blameRebel = this.service.blameRemel(rebelId);
		
		return ResponseEntity.ok(blameRebel);
	}

}
