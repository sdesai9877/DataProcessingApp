package com.app.data.process;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.app.data.model.ReportModel;

public class UniqueCustomerIdByContractId implements IReport<Integer> {

	@Override
	public Map<String, Integer> generateReport(List<ReportModel> reportModels) {
		Map<String, Set<String>> tempReport = new HashMap<>();
		for (ReportModel reportModel : reportModels) {
			tempReport.computeIfAbsent(reportModel.getContractId(), k -> new HashSet<>())
					.add(reportModel.getCustomerId());
		}

		Map<String, Integer> report = new HashMap<>();
		for (Map.Entry<String, Set<String>> entry : tempReport.entrySet()) {
			report.put(entry.getKey(), entry.getValue().size());
		}
		return report;
	}

}
