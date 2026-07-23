# Week 3 - Exercise 1: Create a Spring Web Project using Maven

**Module:** Spring REST using Spring Boot 3
**Status:** Complete

## What this does

Generated a Spring Boot + Maven project skeleton using Spring Initializr,
with the `spring-boot-starter-web` dependency for building RESTful services.

## Verification

- `mvn spring-boot:run` builds and starts successfully
- Embedded Tomcat starts on port 8080
- Hitting `http://localhost:8080` returns Spring Boot's Whitelabel Error 404 page,
  confirming the application context and error-handling pipeline are both live
  (expected result — no controllers have been added yet)
