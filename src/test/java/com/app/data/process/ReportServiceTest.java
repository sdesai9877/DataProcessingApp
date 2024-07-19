package com.app.data.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.app.data.factory.ReportModelFactory;
import com.app.data.model.ReportModel;

public class ReportServiceTest {

	private final String data = """
			2343225,2345,us_east,RedTeam,ProjectApple,3445s
			1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
			3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
			1233456,2345,us_west,BlueTeam,ProjectDate,2221s
			3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
			""";

	private List<ReportModel> getReports() {
		List<ReportModel> reportsModels = new ArrayList<>();
		Arrays.stream(data.split("\\r?\\n")).forEach(line -> reportsModels.add(ReportModelFactory.createReport(line)));
		return reportsModels;
	}

	@Test
	public void testUniqueCustomerIdPerContractCount() {
		List<ReportModel> reportModel = getReports();

		Map<String, Integer> expected = new HashMap<>();
		expected.put("2345", 3);
        expected.put("2346", 2);

		UniqueCustomerIdByContractId customerByContractId = new UniqueCustomerIdByContractId();
		Map<String, Integer> actual = customerByContractId.generateReport(reportModel);

		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testUniqueCustomerIdPerGeoZoneCount() {
		List<ReportModel> reportModel = getReports();

		Map<String, Integer> expected = new HashMap<>();
		expected.put("us_east", 1);
        expected.put("us_west", 2);
        expected.put("eu_west", 2);

		UniqueCustomerIdPerGeoZone customerIdPerGeoZone = new UniqueCustomerIdPerGeoZone();
		Map<String, Integer> actual = customerIdPerGeoZone.generateReport(reportModel);

		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testAverageBuildDurationPerGeoZone() {
		List<ReportModel> reportsModels = getReports();

		Map<String, Double> expected = new HashMap<>();
		expected.put("us_east", 3445.0);
		expected.put("us_west", 2216.0);
		expected.put("eu_west", 4222.0);

		AverageBuildDurationPerGeoZone averageBuildDurationPerGeoZone = new AverageBuildDurationPerGeoZone();
		Map<String, Double> actual = averageBuildDurationPerGeoZone.generateReport(reportsModels);

		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testUniqueCustomerIdsPerGeoZone() {
		List<ReportModel> reportsModels = getReports();

		Map<String, Set<String>> expected = new HashMap<>();
		expected.put("us_east", Set.of("2343225"));
		expected.put("us_west", Set.of("1223456", "1233456"));
		expected.put("eu_west", Set.of("3244332", "3244132"));

		CustomerIdsPerGeoZone customerIdsPerGeoZone = new CustomerIdsPerGeoZone();
		Map<String, Set<String>> actual = customerIdsPerGeoZone.generateReport(reportsModels);

		Assertions.assertEquals(expected, actual);
	}
}
