## Microservices demo with Spring Boot 3.4.1 and Spring Framework 6.x

This microservices demo is based on https://www.youtube.com/watch?v=HFl2dzhVuUo , this demo was tested with Java 17, Spring Boot 3.4.1 and Spring 6.x , you would need to run [Zipkin](https://zipkin.io/pages/quickstart) before running the microservices inside this repo e.g. department-service, employee-service

**If you want to start the microservices, clone the repo and run the projects in the order, config-server, service-registry, api-gateway, department-service, employee-service**

!["Project Components"](images/diagram.png?raw=true)

## Project Structure 

```
├── spring-boot-3-microservices-demo
│   ├── config-server
│   │   ├── src
│   │   ├── pom.xml
│   ├── service-registry
│   │   ├── src
│   │   ├── pom.xml
│   ├── api-gateway
│   │   ├── src
│   │   ├── pom.xml
│   ├── department-service
│   │   ├── src
│   │   ├── pom.xml
│   └── employee-service
│       ├── src
│       ├── pom.xml
```

## IntelliJ Project

!["IntelliJ Project"](images/project.png?raw=true)

## Starting Zipkin Docker Container
```
docker run -d -p 9411:9411 openzipkin/zipkin
```
!["Running Zipkin docker container"](images/zipkin-container.png?raw=true)

## Spring Eureka Server acting as Service Registry

!["Eureka Server"](images/eureka-server.png?raw=true)

# Firing Curl requests
```
curl http://localhost:8060/departments

curl -X POST http://localhost:8060/departments -H "Content-Type: application/json" -d '{ "id": "1", "name": "Computer Science" }'

curl -X POST http://localhost:8060/departments -H "Content-Type: application/json" -d '{ "id": "2", "name": "Civil Engineering" }'

curl http://localhost:8060/departments/1

curl http://localhost:8060/departments

curl http://localhost:8060/employees

curl -X POST http://localhost:8060/employees -H "Content-Type: application/json" -d '{ "id": 1, "departmentId": 1, "name": "Mahtab Alam", "age": 30, "designation": "Lecturer" }'

curl -X POST http://localhost:8060/employees -H "Content-Type: application/json" -d '{ "id": 2, "departmentId": 2, "name": "Reem", "age": 32, "designation": "Lecturer" }'

curl http://localhost:8060/employees/1

curl http://localhost:8060/departments

curl http://localhost:8060/departments/with-employees

curl http://localhost:8060/departments
```
!["Curl Requests"](images/curl-requests.png?raw=true)

## API requests in Zipkin

!["Zipkin API request logging"](images/zipkin.png?raw=true)

!["Zipkin API requests spanning multiple microservices"](images/zipkin-span.png?raw=true)

