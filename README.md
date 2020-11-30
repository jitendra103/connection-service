# Required Technologies
1. mvn
2. Java 8
3. Spring Boot 2.3.x
4. Jersery api



# Overview

This application create a API for checking if path exist between two cities using a predefined map of cities.
1. We have are using  graph data structrue to hold cities info. Data are stored in Adjacency List. Size of list is equal to the node/vertices.
2. Used Depth-first search to find the  conneting vertex.
3. Search is directed i:e origin to destination.

# Default Map

The sample map contains the following paths.  This is configurable and can be changed.

```
Boston, New York
Philadelphia, Newark
Newark, Boston
Trenton, Albany
```

# API documentation and testing tool using swagger



# Development and Execution

This section describes the development and execution environment and steps.  

## Build and Run Unit Test

```
./mvnw clean package
```

## Build and Run Test

```
./mvnw clean test
```

## Run Service


## Run Service with Spring Boot

```
./mvnw clean test spring-boot:run

```

## Run service with external city map file


# Services and Example

This section demonstrate call to invoke the services the application provides. 

## Find Path using curl

Using curl command to run on Unix or Window machine. 

```
curl -X GET -G --data-urlencode "origin=Boston" --data-urlencode "destination=New York" http://localhost:8080/connected
```








