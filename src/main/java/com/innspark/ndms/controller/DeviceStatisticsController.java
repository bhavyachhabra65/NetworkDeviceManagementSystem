package com.innspark.ndms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innspark.ndms.model.Device;
import com.innspark.ndms.model.ManufacturingDateAnalysis;
import com.innspark.ndms.service.DeviceService;

@RestController
@RequestMapping("/deviceStatistics")
public class DeviceStatisticsController {
	
	@Autowired
    private DeviceService deviceService;
	
	@GetMapping("/count")
	public ResponseEntity<Long> getDeviceCount() {
	    long deviceCount = deviceService.getDeviceCount();
	    return ResponseEntity.ok(deviceCount);
	}
	
	@GetMapping("/brands")
	public ResponseEntity<Map<String, Long>> getDeviceDistributionByBrand() {
	    Map<String, Long> brandDistribution = deviceService.getDeviceDistributionByBrand();
	    return ResponseEntity.ok(brandDistribution);
	}
	
	@GetMapping("/version")
    public ResponseEntity<Map<String, Long>> getDeviceVersionStatistics() {
        Map<String, Long> versionStatistics = deviceService.getDeviceVersionStatistics();
        return ResponseEntity.ok(versionStatistics);
    }
	
	@GetMapping("/manufacturing-date-analysis")
	public ResponseEntity<ManufacturingDateAnalysis> getManufacturingDateAnalysis() {
	    ManufacturingDateAnalysis analysis = deviceService.getManufacturingDateAnalysis();
	    return ResponseEntity.ok(analysis);
	}
	
    // API to get the count of devices in a specific status (e.g., online, offline)
    @GetMapping("/status/count")
    public ResponseEntity<Long> getDeviceStatusCount(@RequestParam("status") Boolean status) {
        long count = deviceService.getDeviceCountByStatus(status);
        return ResponseEntity.ok(count);
    }

    // API to get a list of devices with a specific status
    @GetMapping("/status/devices")
    public ResponseEntity<List<Device>> getDevicesByStatus(@RequestParam("status") Boolean status) {
        List<Device> devices = deviceService.getDevicesByStatus(status);
        return ResponseEntity.ok(devices);
    }

    // API to get device status distribution statistics (count of devices in each status)
    @GetMapping("/status/distribution")
    public ResponseEntity<Map<Boolean, Long>> getDeviceStatusDistribution() {
        Map<Boolean, Long> distribution = deviceService.getDeviceStatusDistribution();
        return ResponseEntity.ok(distribution);
    }
   
}