# Required Technologies
1. Maven
2. Java 8
3. Spring Boot 2.3.x
4. Spring Rest Api
5. Junit 4.x
6. logback logger
7. Swagger
8. Spring boot actuator 



# Overview

This application create a API for checking if path or connection exist between two cities using a predefined map of cities.

1. We are using  graph data structure to hold cities info. Data are stored in Adjacency List. Size of list is equal to the node/vertices.
2. Used Depth-first search to find the connecting vertex or node.
3. Search is directed i:e origin to destination.

# Default Map

The sample map contains the following paths. This is configurable and can be changed.

```
Boston, New York
Philadelphia, Newark
Newark, Boston
Trenton, Albany
```

# API documentation and testing tool using swagger

http://localhost:8080/swagger-ui/#/city-connected-controller


# Development and Execution Section

Below are Development and Execution Section

## Build and Run Unit Test

```
[Unix]
./mvnw clean package 

[Window]
mvnw clean package
```

## Run Service

```
[Unix]
./mvnw clean test spring-boot:run

[Window]
mvnw clean test spring-boot:run

```
# Services and Example

This section demonstrate call to invoke the services the application provides. 

## Find Connection using curl

Using curl command to run on Unix or Window machine. 

```
curl -X GET -G --data-urlencode "origin=Boston" --data-urlencode "destination=New York" http://localhost:8080/connected
```


