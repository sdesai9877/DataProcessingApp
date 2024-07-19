package com.app.data.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.data.model.ReportModel;

public class AverageBuildDurationPerGeoZone implements IReport<Double> {

	@Override
	public Map<String, Double> generateReport(List<ReportModel> reportModels) {
		Map<String, Integer> totalDuration = new HashMap<>();
		Map<String, Integer> count = new HashMap<>();
		for (ReportModel reportModel : reportModels) {
			totalDuration.merge(reportModel.getGeozone(), reportModel.getBuildduration(), Integer::sum);
			count.merge(reportModel.getGeozone(), 1, Integer::sum);
		}
		Map<String, Double> report = new HashMap<>();
		for (String geoZone : totalDuration.keySet()) {
			report.put(geoZone, (double) totalDuration.get(geoZone) / count.get(geoZone));
		}
		return report;
	}
}
