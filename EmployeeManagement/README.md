# Employee Management System using Spring MVC

## Features
- Employee registration and listing with JSP
- Spring MVC controller, service, and repository layers
- Bean validation for employee fields
- Spring AOP audit logging
- JUnit 5 and Mockito service tests

## Requirements
- JDK 17
- Maven
- Apache Tomcat 10.1+
- Eclipse or IntelliJ IDEA (optional)

## Run
1. Open a terminal in the project directory.
2. Run tests: `mvn clean test`
3. Build WAR: `mvn clean package`
4. Deploy `target/EmployeeManagement.war` to Tomcat.
5. Open `http://localhost:8080/EmployeeManagement/`

## Important
This sample uses in-memory storage, not MySQL. Employee records are lost when the application restarts. It is a learning/demo project and does not include authentication or persistent audit storage.
