package com.innspark.ndms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innspark.ndms.model.Device;
import com.innspark.ndms.model.DeviceProjection;
import com.innspark.ndms.repository.DeviceRepository;

@RestController
@RequestMapping("/devices")
public class DeviceManagementController {

    @Autowired
    private DeviceRepository deviceRepository;

    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return deviceRepository.save(device);
    }

    @GetMapping
    public List<DeviceProjection> getAllDevices() {
        return deviceRepository.findAllBy();
    }
    
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("HEllo");
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long deviceId) {
        Optional<Device> device = deviceRepository.findById(deviceId);
        if (device.isPresent()) {
            return ResponseEntity.ok(device.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{deviceId}")
    public ResponseEntity<Device> updateDevice(
            @PathVariable Long deviceId,
            @RequestBody Device updatedDevice) {
        Optional<Device> device = deviceRepository.findById(deviceId);
        if (device.isPresent()) {
            Device existingDevice = device.get();
            existingDevice.setName(updatedDevice.getName());
            existingDevice.setVersion(updatedDevice.getVersion());
            existingDevice.setBrand(updatedDevice.getBrand());
            existingDevice.setManufacturingDate(updatedDevice.getManufacturingDate());
            existingDevice.setDeviceStatus(updatedDevice.getDeviceStatus());
            deviceRepository.save(existingDevice);
            return ResponseEntity.ok(existingDevice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{deviceId}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long deviceId) {
        Optional<Device> device = deviceRepository.findById(deviceId);
        if (device.isPresent()) {
            deviceRepository.delete(device.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
