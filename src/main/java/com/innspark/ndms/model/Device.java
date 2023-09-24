package com.innspark.ndms.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEVICE")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String version;
    private String brand;
    
    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;
    private Boolean deviceStatus;
    
    public Device() {
    	super();
    }
    
	public Device(Long id, String name, String version, String brand, LocalDate manufacturingDate, Boolean deviceStatus) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.brand = brand;
		this.manufacturingDate = manufacturingDate;
		this.deviceStatus = deviceStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	
    public Boolean getDeviceStatus() {
        return deviceStatus;
    }


	public void setDeviceStatus(Boolean deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", version=" + version + ", brand=" + brand
				+ ", manufacturingDate=" + manufacturingDate + ", deviceStatus=" + deviceStatus + "]";
	}

	
}