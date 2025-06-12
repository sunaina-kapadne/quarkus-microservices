# quarkus-microservices
#### Quarkus version: 3.21.3
#### Covered Scope: Inter-comminucation, Restful API, Database: Postgresql, H2, Fault Tolerance

#### This is a simple multi-module Quarkus project with two microservices:
- **offer-microservice** runs on port 8081
- **price-microservice** runs on port 8082
------------------------------------
## offer-microservice:
### Covered Scope: 
#### CDI, REST, Panache, PostgreSql, Fault Tolerance, JUnit5, Rest Assured, RestEasy, Microprofile

### Endpoints:
#### 1. /offers : Get all offers
#### 2. /offer-price : Get all Offers with Prices (internally call for Price retrieval API)

---------

## price-microservice: 
### Covered Scope: 
#### CDI, REST, Panache, H2, JUnit5, Rest Assured, RestEasy, Microprofile

### Endpoints:
#### 1. /prices : Get all Prices
