package com.app.data.process;

import java.util.List;
import java.util.Map;

import com.app.data.model.ReportModel;

public interface IReport<T> {

	Map<String, T> generateReport(List<ReportModel> reports);

}
