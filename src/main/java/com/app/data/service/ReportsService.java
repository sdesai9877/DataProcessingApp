package com.app.data.service;

import java.util.List;
import java.util.Map;

import com.app.data.model.ReportModel;
import com.app.data.process.IReport;

public class ReportsService {

	private static ReportsService reportsService;

	private ReportsService() {
	}

	public static ReportsService getReportsService() {
		if (reportsService == null) {
			reportsService = new ReportsService();
		}
		return reportsService;
	}

	public <T> Map<String, T> executeReport(IReport<T> report, List<ReportModel> reports) {
		return report.generateReport(reports);
	}

}
