package com.app.data.model;

public class ReportModel {

	private final String customerId;
	private final String contractId;
	private final String geozone;
	private final String teamcode;
	private final String projectcode;
	private final int buildduration;

	public ReportModel(String customerId, String contractId, String geozone, String teamcode, String projectcode,
			int buildduration) {
		this.customerId = customerId;
		this.contractId = contractId;
		this.geozone = geozone;
		this.teamcode = teamcode;
		this.projectcode = projectcode;
		this.buildduration = buildduration;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getContractId() {
		return contractId;
	}

	public String getGeozone() {
		return geozone;
	}

	public String getTeamcode() {
		return teamcode;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public int getBuildduration() {
		return buildduration;
	}

}
