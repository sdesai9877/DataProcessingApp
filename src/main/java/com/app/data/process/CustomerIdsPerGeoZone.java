package com.app.data.process;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.app.data.model.ReportModel;

public class CustomerIdsPerGeoZone implements IReport<Set<String>> {

	@Override
    public Map<String, Set<String>> generateReport(List<ReportModel> reportModels) {
        Map<String, Set<String>> report = new HashMap<>();
        for (ReportModel reportModel : reportModels) {
            report.computeIfAbsent(reportModel.getGeozone(), k -> new HashSet<>()).add(reportModel.getCustomerId());
        }
        return report;
    }

}
