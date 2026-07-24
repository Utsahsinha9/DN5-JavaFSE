# Week 4 - Exercise: Creating Microservices for Account and Loan

## Overview

Two independent Spring Boot microservices, each with its own `pom.xml`,
demonstrating basic REST API creation with no shared code or backend connectivity.

## Account Microservice

- Port: 8080
- Endpoint: `GET /accounts/{number}`
- Sample: `http://localhost:8080/accounts/00987987973432`
- Sample Response:

```json
{ "number": "00987987973432", "type": "savings", "balance": 234343 }
```

## Loan Microservice

- Port: 8081
- Endpoint: `GET /loans/{number}`
- Sample: `http://localhost:8081/loans/H00987987972342`
- Sample Response:

```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000,
  "emi": 3258,
  "tenure": 18
}
```

## How to Run

Each service is run independently from its own root folder (where `pom.xml` lives):

```bash
cd account
mvn spring-boot:run
```

```bash
cd loan
mvn spring-boot:run
```

Both can run simultaneously since they use different ports (8080 and 8081).

## Notes

- Account was configured with default port 8080.
- Loan required an explicit `server.port=8081` in `application.properties`
  to avoid a port conflict with Account.
