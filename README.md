# Network Device Management System

## Description

The Network Device Management System is a Java Spring Boot-based application designed for managing network devices. It allows users to perform various operations related to network devices, such as adding, fetching, updating, and deleting devices. Additionally, the system provides statistics and analysis related to device data, including device count, brand distribution, device version statistics, manufacturing date analysis, and device status statistics.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 11 or higher
- Apache Maven
- Postman (for testing APIs)

## Pre-Added Entries in H2 Database

The application comes with a pre-populated H2 database with the following entries:

INSERT INTO DEVICE (name, version, brand, manufacturing_date, device_status) VALUES
  ('Device 1', 'Version 1', 'Brand A', '2023-09-21', True),
  ('Device 2', 'Version 2', 'Brand B', '2023-09-22', True),
  ('Device 3', 'Version 3', 'Brand C', '2023-09-23', False);


API Details


1. Create a New Device (POST)
Endpoint: /devices
Method: POST
Description: Creates a new device with basic information.
Sample Request Body:
{
  "name": "Device Name",
  "version": "Version 1",
  "brand": "Brand A",
  "manufacturingDate": "2023-09-24",
  "deviceStatus": true
}

2. Get a List of Devices (GET)
Endpoint: /devices
Method: GET
Description: Retrieves a list of all devices.

3. Get Device by ID (GET)
Endpoint: /devices/{deviceId}
Method: GET
Description: Retrieves detailed information about a specific device.

4. Update Device Information (PUT)
Endpoint: /devices/{deviceId}
Method: PUT
Description: Updates information about an existing device.
Sample Request Body:
{
  "name": "Updated Device Name",
  "version": "Version 2",
  "brand": "Brand B",
  "manufacturingDate": "2023-09-25",
  "deviceStatus": false
}

5. Delete a Device (DELETE)
Endpoint: /devices/{deviceId}
Method: DELETE
Description: Deletes a device by ID.

6. Get Device Count (GET)
Endpoint: /deviceStatistics/count
Method: GET
Description: Returns the total count of devices in the system.

7. Get Device Distribution by Brand (GET)
Endpoint: /deviceStatistics/brands
Method: GET
Description: Returns the distribution of devices by brand.

8. Get Device Version Statistics (GET)
Endpoint: /deviceStatistics/version
Method: GET
Description: Provides statistics on the distribution of device versions.

9. Get Manufacturing Date Analysis (GET)
Endpoint: /deviceStatistics/manufacturing-date-analysis
Method: GET
Description: Analyzes and provides statistics on device manufacturing dates.

10. Get Device Status Count (GET)
Endpoint: /deviceStatistics/count?status=true
Method: GET
Description: Returns the count of devices with a specific status (e.g., online).

11. Get Devices by Status (GET)
Endpoint: /deviceStatistics/devices?status=true
Method: GET
Description: Retrieves a list of devices with a specific status (e.g., online).

12. Get Device Status Distribution (GET)
Endpoint: /deviceStatistics/distribution
Method: GET
Description: Provides statistics on device statuses.


Special Points About the Project

Exception Handling: The project uses Spring Boot's exception handling mechanism, including a GlobalExceptionHandler class that handles specific exceptions, such as DeviceNotFoundException, and returns meaningful error messages.

Java Streams: Java Streams are used for data processing and analysis. For example, in the DeviceService class, streams are used to calculate statistics like device distribution by brand, device version statistics, and manufacturing date analysis.

Pre-populated H2 Database: The application starts with a pre-populated H2 database containing sample device data, simplifying testing and demonstration of APIs.

RESTful API Design: The project follows RESTful API design principles, providing clear and consistent endpoints for CRUD operations and statistics retrieval.

Controller Advice: The GlobalExceptionHandler class is annotated with @ControllerAdvice and handles exceptions globally, ensuring standardized and informative error responses.

Environment Configuration: The project includes a Postman environment file (postman/environment.json) for easy API testing. Importing this environment into Postman sets up variables for different endpoints.

Java 11: The project is developed using Java 11, offering modern language features and improved performance. It runs with Java 17 due to Maven's default settings.

Maven Build: The project uses Apache Maven for simplified dependency management and project compilation.

Feel free to explore and use the provided APIs to manage and analyze network devices efficiently!

