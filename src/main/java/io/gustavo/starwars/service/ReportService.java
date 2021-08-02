package io.gustavo.starwars.service;

import org.springframework.stereotype.Service;

import io.gustavo.starwars.report.Report;
import io.gustavo.starwars.report.ReportFactory;
import io.gustavo.starwars.report.ReportResult;

@Service
public class ReportService {

	private ReportFactory factory;
	
	public ReportService(ReportFactory factory) {
		this.factory = factory;
	}
	
	public ReportResult generateResult(String type) {
		Report report = factory.getReport(type);
		return report.build();
	}
	
}
