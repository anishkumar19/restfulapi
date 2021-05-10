# Spring Boot RESTful API Project

This project provides RESTful APIs for CRUD interaction with user accounts.

## How to Run 

This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar target/app.jar
        
```

Once the application runs you should see something like this

```
2021-05-03 21:04:30.187  INFO 51132 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-05-03 21:04:30.205  INFO 51132 --- [           main] c.a.nokia.restfulapi.Application         : Started Application in 14.23 seconds (JVM running for 15.849)
```

## About the Service

The service is just a simple REST service. It uses an in-memory database (H2) to store the data. All APIs are "self-documented" by Swagger2 using annotations 

### To view Swagger 2 API docs

Run the server and browse to http://localhost:8080/swagger-ui.html

### To view your H2 in-memory datbase

To view and query the database you can browse to http://localhost:8080/h2-console. 
Username is 'sa', password is 'password' and JDBC URL is 'jdbc:h2:mem:test_database'.


