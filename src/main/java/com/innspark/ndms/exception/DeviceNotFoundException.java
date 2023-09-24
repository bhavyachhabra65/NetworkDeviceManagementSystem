package com.innspark.ndms.exception;

public class DeviceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	 
    public DeviceNotFoundException() {
        super("Device not found"); // Default error message
    }

    public DeviceNotFoundException(String message) {
        super(message);
    }

}