package io.gustavo.starwars.service;

import org.springframework.stereotype.Service;

import io.gustavo.starwars.report.Report;
import io.gustavo.starwars.report.ReportFactory;
import io.gustavo.starwars.report.ReportResult;
import io.gustavo.starwars.report.ReportType;

@Service
public class ReportService {

	private ReportFactory factory;
	
	public ReportService(ReportFactory factory) {
		this.factory = factory;
	}
	
	public ReportResult generateResult(ReportType type, String resource) {
		Report report = factory.getReport(type, resource);
		return report.build();
	}
	
}
