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
--header 'codeBanque: 00003' \
--header 'Authorization: Bearer a48f846a-106d-32c7-b669-1283129a5243' \
--header 'X-JWT-Assertion: Bearer eyJ4NXQiOiJOVEF4Wm1NeE5ETXlaRGczTVRVMVpHTTBNekV6T0RKaFpXSTRORE5sWkRVMU9HRmtOakZpTVEiLCJraWQiOiJOVEF4Wm1NeE5ETXlaRGczTVRVMVpHTTBNekV6T0RKaFpXSTRORE5sWkRVMU9HRmtOakZpTVEiLCJhbGciOiJSUzI1NiJ9.eyJhdF9oYXNoIjoiamVUckJrQ0c1enF4dDlmcllvRUtWZyIsImF1ZCI6IlZ2SWljZjZWaF9PX1lURUR1MG0xU3gybEtwa2EiLCJjX2hhc2giOiJyQk13THRKVzdFMVhCSmIwcVVVd0R3Iiwic3ViIjoiYWRzZ2FicyIsIm5iZiI6MTY3ODA5NDQ1NSwiYXpwIjoiVnZJaWNmNlZoX09fWVRFRHUwbTFTeDJsS3BrYSIsImFtciI6WyJCYXNpY0F1dGhlbnRpY2F0b3IiXSwiaXNzIjoiaHR0cHM6XC9cL2xvY2FsaG9zdDo5NDQzXC9vYXV0aDJcL3Rva2VuIiwiZXhwIjoxNjc4NDU0NDU1LCJpYXQiOjE2NzgwOTQ0NTUsInNpZCI6IjY2Yjg3NDA1LWRhZmUtNGY0Yi04YWFmLWYyNzU3MTVhY2U0MyJ9.adXp1fM8wzM1LqTzWAkObVteKVj_63EtP4BZo7nvclxB48ULTPSV0RiOVrDh2kSAm4ttuhIKErn6nia9RS3EjGe_VIt1Doar7gU-Q-AsqLfh-Xn4LW3HJnvO1cctKZScx7ssKcJNzexe544-Km8my7z8FWa9pdPq2ve_7I4syc_Nssf6wRA3GvbG3_1okjj8cWTh3m1NerZY0N6CrHkOqULGJiTtt8aXGP2hJxbcraIRJwaugYEssYt9gDAMJe1M1SoGIBJrJbPVS0D0LCmA9qzhMm4zwsmDvQriVl2YftdYAk-qwhCaUspFBrXdZsKt8wHlbsalseE6s_bmqE1_qQ' \
--header 'Content-Type: application/json;charset=UTF-8' \
--header 'platform: WEB' \
--header 'Origin: http://localhost:3002' \
--header 'DNT: 1' \
--header 'Connection: keep-alive' \
--header 'Referer: http://localhost:3002/' \
--header 'Sec-Fetch-Dest: empty' \
--header 'Sec-Fetch-Mode: cors' \
--header 'Sec-Fetch-Site: same-site' \
--header 'Pragma: no-cache' \
--header 'Cache-Control: no-cache' \
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
--header 'codeBanque: 00003' \
--header 'Authorization: Bearer a48f846a-106d-32c7-b669-1283129a5243' \
--header 'X-JWT-Assertion: Bearer eyJ4NXQiOiJOVEF4Wm1NeE5ETXlaRGczTVRVMVpHTTBNekV6T0RKaFpXSTRORE5sWkRVMU9HRmtOakZpTVEiLCJraWQiOiJOVEF4Wm1NeE5ETXlaRGczTVRVMVpHTTBNekV6T0RKaFpXSTRORE5sWkRVMU9HRmtOakZpTVEiLCJhbGciOiJSUzI1NiJ9.eyJhdF9oYXNoIjoiamVUckJrQ0c1enF4dDlmcllvRUtWZyIsImF1ZCI6IlZ2SWljZjZWaF9PX1lURUR1MG0xU3gybEtwa2EiLCJjX2hhc2giOiJyQk13THRKVzdFMVhCSmIwcVVVd0R3Iiwic3ViIjoiYWRzZ2FicyIsIm5iZiI6MTY3ODA5NDQ1NSwiYXpwIjoiVnZJaWNmNlZoX09fWVRFRHUwbTFTeDJsS3BrYSIsImFtciI6WyJCYXNpY0F1dGhlbnRpY2F0b3IiXSwiaXNzIjoiaHR0cHM6XC9cL2xvY2FsaG9zdDo5NDQzXC9vYXV0aDJcL3Rva2VuIiwiZXhwIjoxNjc4NDU0NDU1LCJpYXQiOjE2NzgwOTQ0NTUsInNpZCI6IjY2Yjg3NDA1LWRhZmUtNGY0Yi04YWFmLWYyNzU3MTVhY2U0MyJ9.adXp1fM8wzM1LqTzWAkObVteKVj_63EtP4BZo7nvclxB48ULTPSV0RiOVrDh2kSAm4ttuhIKErn6nia9RS3EjGe_VIt1Doar7gU-Q-AsqLfh-Xn4LW3HJnvO1cctKZScx7ssKcJNzexe544-Km8my7z8FWa9pdPq2ve_7I4syc_Nssf6wRA3GvbG3_1okjj8cWTh3m1NerZY0N6CrHkOqULGJiTtt8aXGP2hJxbcraIRJwaugYEssYt9gDAMJe1M1SoGIBJrJbPVS0D0LCmA9qzhMm4zwsmDvQriVl2YftdYAk-qwhCaUspFBrXdZsKt8wHlbsalseE6s_bmqE1_qQ' \
--header 'Content-Type: application/json;charset=UTF-8' \
--header 'platform: WEB' \
--header 'Origin: http://localhost:3002' \
--header 'DNT: 1' \
--header 'Connection: keep-alive' \
--header 'Referer: http://localhost:3002/' \
--header 'Sec-Fetch-Dest: empty' \
--header 'Sec-Fetch-Mode: cors' \
--header 'Sec-Fetch-Site: same-site' \
--header 'Pragma: no-cache' \
--header 'Cache-Control: no-cache' \
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
