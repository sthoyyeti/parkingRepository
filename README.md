# ParkingRepository
This is primary service storing and retrieving parking status.

By default Spring boot connects to locally running Mongo DB.

## Override following Mongo DB properties via java VM or environment variables.
<ul>
<li>spring.data.mongodb.host=localhost</li>
<li>spring.data.mongodb.port=27017</li>
</ul>
	
## Get listing of services available, Start application just type http://localhost:8080/ 
Spring HATEOAS provides some APIs to ease creating REST representations that follow the HATEOAS principle when working with Spring and especially Spring MVC. The core problem it tries to address is link creation and representation assembly.
(or) Refer to REST based tests to know services available. 

## Start application
<ol>
<li>Install Mongo DB and start</li>
<li>Clone https://github.com/sthoyyeti/parkingRepository.git</li>
<li>mvn clean install</li>
<li>java -jar target/ParkingSpaceAdvisor-0.0.1-SNAPSHOT.jar -Dspring.data.mongodb.host=localhost -Dspring.data.mongodb.port=27017</li>
</ol>