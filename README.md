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

## The curl to test the creation api (to be imported in postman)

``` shell
curl --location 'http://localhost:5050/create' \
--header 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/110.0' \
--header 'Accept: */*' \
--header 'Accept-Language: en-US,en;q=0.5' \
--header 'Accept-Encoding: gzip, deflate, br' \
--header 'Content-Type: application/json;charset=UTF-8' \
--data-raw '{
    "name": "aymane bendahmane",
    "email": "meowmeow@gmail.com",
    "password": "12345678Aa=",
    "educations": [
        {
            "title": "developement web et genie logiciel"
        },
        {
            "title": "Miage ASCI"
        }
    ],
    "workExperiences": [
        {
            "jobTitle": "ingenieur d'\''etude et developement informatique at ADRIA B&T",
            "startDate": "2022-01-03",
            "present": true
        },
        {
            "jobTitle": "Stage pre-embouche at ADRIA B&T",
            "startDate": "2021-10-10",
            "endDate": "2021-12-31"
        }
    ]
}'
```
## The curl to test the update api (to be imported in postman)
``` shell
curl --location --request PUT 'http://localhost:5050/update/1' \
--header 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/110.0' \
--header 'Accept: */*' \
--header 'Accept-Language: en-US,en;q=0.5' \
--header 'Accept-Encoding: gzip, deflate, br' \
--header 'Content-Type: application/json;charset=UTF-8' \
--data-raw '{
    "name": "aymane tets",
    "email": "meowmeow@gmail.com",
    "password": "12345678Aa$",
    "educations": [
        {
            "title": "developement web et genie logiciel at isga"
        },
        {
            "title": "Miage ASCI at university of lorrain"
        }
    ],
    "workExperiences": [
        {
            "jobTitle": "ingenieur d'\''etude et developement informatique at ADRIA B&T",
            "startDate": "2022-01-03",
            "present": true
        },
        {
            "jobTitle": "Stage pre-embouche at ADRIA B&T",
            "startDate": "2021-10-10",
            "endDate": "2021-12-31"
        }
    ]
}'
```
