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
		double count = rebels.size();
		double traitor = rebelRepository.findTraitors().size();
		
		result.setValue(String.valueOf((traitor / count) * 100d));
		
		return result;
	}

}
