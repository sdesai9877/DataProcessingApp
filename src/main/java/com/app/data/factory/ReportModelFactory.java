package com.app.data.factory;

import com.app.data.model.ReportModel;

public class ReportModelFactory {
	
	public static ReportModel createReport(String data) {
        String[] fields = data.split(",");
        return new ReportModel(
            fields[0],
            fields[1],
            fields[2],
            fields[3],
            fields[4],
            Integer.parseInt(fields[5].replace("s", ""))
        );
	}

}
