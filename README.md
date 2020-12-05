# Retail Store Discounts
This is a retail store discount service


This service uses: 
 - Java 11
 - Spring Boot
 - Strategy Design pattern for taking decision 
 - Maven
 - Swagger UI
 - Hibernate
 - MySql DB
 - Junit for unit testing
 
 
 You can check the class diagram in resource/docs/class-diagram
 
 This service assuming the request sent from a service which already has a security layer, so no security layers added to this service
 
 
 Prerequisite:
 
 1 - Clone the repository `git clone git@github.com:hitham-ramzy/task.git` 
 
 2 - Change directory to the project directory `cd task/`
 
 3 - Run Maven to download the dependencies `maven compile`
 
 4 - Create DB `./create-db.cmd` and add your DB username and password
 
 5 - Create DB schema `./create-schema.cmd`
 
 6 - change application.properties file with your DB username and password
 
 7 - Start the project either from your IDE or by running `mvn package` then `java -jar ...`
 
 8 - check your `localhost:8080`
 
 hope you enjoy ;)
