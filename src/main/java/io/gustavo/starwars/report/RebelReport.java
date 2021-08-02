package io.gustavo.starwars.report;

import io.gustavo.starwars.repository.RebelRepository;

public class RebelReport implements Report {

private RebelRepository rebelRepository;
	
	public RebelReport(RebelRepository rebelRepository) {
		this.rebelRepository = rebelRepository;
	}

	@Override
	public ReportResult build() {
		var result = new ReportResult();
		
		var rebels = rebelRepository.findAll();
		var count = rebels.size();
		var rebelCount = rebels.stream().filter(rebel -> rebel.getAccusations() > 2).count();
		
		result.setValue((rebelCount / count) * 100d);
		
		return result;
	}

}
