package com.innspark.ndms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innspark.ndms.model.Device;
import com.innspark.ndms.model.DeviceProjection;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	
	List<DeviceProjection> findAllBy();
	
	long countByDeviceStatus(Boolean deviceStatus);

    List<Device> findByDeviceStatus(Boolean deviceStatus);
}