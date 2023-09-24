package com.innspark.ndms.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innspark.ndms.exception.DeviceNotFoundException;
import com.innspark.ndms.model.Device;
import com.innspark.ndms.model.ManufacturingDateAnalysis;
import com.innspark.ndms.repository.DeviceRepository;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;

	public long getDeviceCount() {
		// Assuming you have a JpaRepository for device entities
		return deviceRepository.count();
	}

	public Map<String, Long> getDeviceDistributionByBrand() {
		List<Device> devices = deviceRepository.findAll(); // Retrieve all devices from the database

		// Create a map to store the brand distribution
		Map<String, Long> brandDistribution = new HashMap<>();

		// Iterate through the devices and count the distribution by brand
		for (Device device : devices) {
			String brand = device.getBrand();

			// If the brand is not in the map, initialize it with 1, otherwise, increment
			// the count
			brandDistribution.put(brand, brandDistribution.getOrDefault(brand, 0L) + 1);
		}

		return brandDistribution;
	}

	public Map<String, Long> getDeviceVersionStatistics() {
		List<Device> devices = deviceRepository.findAll(); // Retrieve all devices from the database

		// Create a map to store the version statistics
		Map<String, Long> versionStatistics = new HashMap<>();

		// Iterate through the devices and count the statistics by version
		for (Device device : devices) {
			String version = device.getVersion();

			// If the version is not in the map, initialize it with 1, otherwise, increment
			// the count
			versionStatistics.put(version, versionStatistics.getOrDefault(version, 0L) + 1);
		}

		return versionStatistics;
	}

	public ManufacturingDateAnalysis getManufacturingDateAnalysis() {
		List<Device> devices = deviceRepository.findAll();
		ManufacturingDateAnalysis analysis = new ManufacturingDateAnalysis();

		if (!devices.isEmpty()) {
			// Calculate average manufacturing date
			long totalDays = devices.stream().mapToLong(device -> device.getManufacturingDate().toEpochDay()).sum();
			long averageDays = totalDays / devices.size();
			LocalDate averageManufacturingDate = LocalDate.ofEpochDay(averageDays);
			analysis.setAverageManufacturingDate(averageManufacturingDate);

			// Find earliest and latest manufacturing dates
			LocalDate earliestManufacturingDate = devices.stream().map(Device::getManufacturingDate)
					.min(LocalDate::compareTo).orElse(null);
			analysis.setEarliestManufacturingDate(earliestManufacturingDate);

			LocalDate latestManufacturingDate = devices.stream().map(Device::getManufacturingDate)
					.max(LocalDate::compareTo).orElse(null);
			analysis.setLatestManufacturingDate(latestManufacturingDate);

			// Calculate devices per month
			Map<Month, Long> devicesPerMonth = devices.stream().collect(Collectors.groupingBy(
					device -> YearMonth.from(device.getManufacturingDate()).getMonth(), Collectors.counting()));
			analysis.setDevicesPerMonth(devicesPerMonth);
		} else {
			throw new DeviceNotFoundException("No devices found for analysis.");
		}

		return analysis;
	}

	// Method to get the count of devices in a specific status (true for online,
	// false for offline)
	public long getDeviceCountByStatus(Boolean status) {
		return deviceRepository.countByDeviceStatus(status);
	}

	// Method to get a list of devices with a specific status
	public List<Device> getDevicesByStatus(Boolean status) {
		List<Device> devices = deviceRepository.findByDeviceStatus(status);
		if (devices.isEmpty()) {
			throw new DeviceNotFoundException("No devices found with the specified status.");
		}
		return devices;
	}

	// Method to get device status distribution statistics (count of devices in each
	// status)
	public Map<Boolean, Long> getDeviceStatusDistribution() {
		Map<Boolean, Long> distribution = new HashMap<>();
		distribution.put(true, deviceRepository.countByDeviceStatus(true));
		distribution.put(false, deviceRepository.countByDeviceStatus(false));
		return distribution;
	}
}
