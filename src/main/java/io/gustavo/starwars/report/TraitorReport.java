package io.gustavo.starwars.report;

import io.gustavo.starwars.repository.RebelRepository;

public class TraitorReport implements Report {

	private RebelRepository rebelRepository;
	
	public TraitorReport(RebelRepository rebelRepository) {
		this.rebelRepository = rebelRepository;
	}

	@Override
	public ReportResult build() {
		var result = new ReportResult();
		
		var rebels = rebelRepository.findAll();
		var count = rebels.size();
		var traitor = rebels.stream().filter(rebel -> rebel.getAccusations() > 2).count();
		
		result.setValue((traitor / count) * 100d);
		
		return result;
	}

}
