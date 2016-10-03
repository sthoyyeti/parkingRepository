# ParkingRepository
This is primary service storing and retrieving parking status.

By default Spring boot connects to locally running Mongo DB.

## Override following Mongo DB properties via java VM or environment variables.
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017

## Get listing of services available just type http://localhost:8080/ 
Spring HATEOAS provides some APIs to ease creating REST representations that follow the HATEOAS principle when working with Spring and especially Spring MVC. The core problem it tries to address is link creation and representation assembly.
(or) Refer to REST based tests to know services available. 