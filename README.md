# TaskFlow API

REST API for managing tasks. Built while learning Spring Boot.

## Endpoints

| Method | URL | What it does |
|---|---|---|
| GET | /api/tasks | List all tasks |
| GET | /api/tasks/{id} | Get one task |
| POST | /api/tasks | Create a task |
| PUT | /api/tasks/{id} | Update a task |
| DELETE | /api/tasks/{id} | Delete a task |

## Tech

Java 17, Spring Boot, Spring Data JPA, H2, Maven

## Run

./mvnw spring-boot:run

Runs at http://localhost:8080/api/tasks