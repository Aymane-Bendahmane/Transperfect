# Spring Boot project

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3.8.1](https://maven.apache.org)

## Dependencies

- Spring Boot (2.7.9)
- Spring Boot Starter Validation
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot DevTools
- H2 Database
- Spring Boot Configuration Processor
- Project Lombok
- JUnit (4.13.2)

## Building from source

To build the application from source, run the following command:

```shell
 mvn clean package
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.

```shell
mvn spring-boot:run
```

This will start the application on port 5050. You can access it by visiting http://localhost:5050 in your web browser.

> **_NOTE:_**  I didn't use Dtos just because the main difference between the entity and the dto is the **id** 🙂, so I added the **@JsonIgnore** annotation to the id to indicate that it should be ignored
