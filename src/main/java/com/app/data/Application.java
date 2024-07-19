package com.app.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.app.data.factory.ReportModelFactory;
import com.app.data.model.ReportModel;
import com.app.data.process.AverageBuildDurationPerGeoZone;
import com.app.data.process.UniqueCustomerIdByContractId;
import com.app.data.process.UniqueCustomerIdPerGeoZone;
import com.app.data.process.CustomerIdsPerGeoZone;
import com.app.data.service.ReportsService;

public class Application {

	public static void main(String[] args) {
		String data = """
                2343225,2345,us_east,RedTeam,ProjectApple,3445s
                1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
                3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
                1233456,2345,us_west,BlueTeam,ProjectDate,2221s
                3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
                """;

        List<ReportModel> reports = new ArrayList<>();
        Arrays.stream(data.split("\\r?\\n")).forEach(line -> reports.add(ReportModelFactory.createReport(line)));

        ReportsService reportService = ReportsService.getReportsService();

        System.out.println("The number of unique customerId for each contractId:");
        Map<String, Integer> contractReport = reportService.executeReport(new UniqueCustomerIdByContractId(), reports);
        contractReport.forEach((k, v) -> System.out.println("Contract ID: " + k + ", Unique Customer ID Count: " + v));

        System.out.println("\nThe number of unique customerId for each geozone:");
        Map<String, Integer> geoZoneReport = reportService.executeReport(new UniqueCustomerIdPerGeoZone(), reports);
        geoZoneReport.forEach((k, v) -> System.out.println("Geozone: " + k + ", Unique Customer ID Count: " + v));

        System.out.println("\nThe average build duration for each geozone:");
        Map<String, Double> durationReport = reportService.executeReport(new AverageBuildDurationPerGeoZone(), reports);
        durationReport.forEach((k, v) -> System.out.println("Geozone: " + k + ", Average Build Duration: " + v + "s"));

        System.out.println("\nThe list of unique customerId for each geozone:");
        Map<String, Set<String>> uniqueIdsReport = reportService.executeReport(new CustomerIdsPerGeoZone(), reports);
        uniqueIdsReport.forEach((k, v) -> System.out.println("Geozone: " + k + ", Unique Customer IDs: " + v));

	}
}
