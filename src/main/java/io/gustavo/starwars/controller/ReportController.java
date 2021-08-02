package io.gustavo.starwars.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.gustavo.starwars.report.ReportResult;
import io.gustavo.starwars.report.ReportType;
import io.gustavo.starwars.service.ReportService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

	private ReportService service;
	
	public ReportController (ReportService service) {
		this.service = service;
	}
	
	
	@ApiOperation(value = "Gerar relatório", notes = "Gerar relatório", response = ReportResult.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Relatório gerado com sucesso"),
			@ApiResponse(code = 400, message = "Tipo de relatório não existe")
	})
	@GetMapping
	public ResponseEntity<ReportResult> getReport(@RequestParam(required = true) ReportType type, 
			@RequestParam(required = false) String resource){
		var result = service.generateResult(type, resource);
		
		return ResponseEntity.ok(result);
	}
}
