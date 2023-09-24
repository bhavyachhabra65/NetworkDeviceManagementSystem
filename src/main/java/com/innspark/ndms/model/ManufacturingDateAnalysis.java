package com.innspark.ndms.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

public class ManufacturingDateAnalysis {
    private LocalDate averageManufacturingDate;
    private LocalDate earliestManufacturingDate;
    private LocalDate latestManufacturingDate;
    private Map<Month, Long> devicesPerMonth;
	
    public ManufacturingDateAnalysis() {
		super();
	}

	public ManufacturingDateAnalysis(LocalDate averageManufacturingDate, LocalDate earliestManufacturingDate,
			LocalDate latestManufacturingDate, Map<Month, Long> devicesPerMonth) {
		super();
		this.averageManufacturingDate = averageManufacturingDate;
		this.earliestManufacturingDate = earliestManufacturingDate;
		this.latestManufacturingDate = latestManufacturingDate;
		this.devicesPerMonth = devicesPerMonth;
	}

	public LocalDate getAverageManufacturingDate() {
		return averageManufacturingDate;
	}

	public void setAverageManufacturingDate(LocalDate averageManufacturingDate) {
		this.averageManufacturingDate = averageManufacturingDate;
	}

	public LocalDate getEarliestManufacturingDate() {
		return earliestManufacturingDate;
	}

	public void setEarliestManufacturingDate(LocalDate earliestManufacturingDate) {
		this.earliestManufacturingDate = earliestManufacturingDate;
	}

	public LocalDate getLatestManufacturingDate() {
		return latestManufacturingDate;
	}

	public void setLatestManufacturingDate(LocalDate latestManufacturingDate) {
		this.latestManufacturingDate = latestManufacturingDate;
	}

	public Map<Month, Long> getDevicesPerMonth() {
		return devicesPerMonth;
	}

	public void setDevicesPerMonth(Map<Month, Long> devicesPerMonth) {
		this.devicesPerMonth = devicesPerMonth;
	}

	@Override
	public String toString() {
		return "ManufacturingDateAnalysis [averageManufacturingDate=" + averageManufacturingDate
				+ ", earliestManufacturingDate=" + earliestManufacturingDate + ", latestManufacturingDate="
				+ latestManufacturingDate + ", devicesPerMonth=" + devicesPerMonth + "]";
	}

    
}
