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
		double count = rebels.size();
		double rebelCount = rebels.stream().filter(rebel -> rebel.getAccusations() < 3).count();
		
		result.setValue(String.valueOf((rebelCount / count) * 100d));
		
		return result;
	}

}
