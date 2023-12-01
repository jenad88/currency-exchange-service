# currency-exchange-service
currency-exchange-service for playing around with ECS Fargate from in28minutes

# Currency Exchange Micro Service - H2

Run com.johnenad.microservices.currencyconversionservice.CurrencyConversionServiceApplication as a Java Application.

## Containerization

https://spring.io/guides/topicals/spring-boot-docker/

### Troubleshooting

- Problem - Caused by: com.spotify.docker.client.shaded.javax.ws.rs.ProcessingException: java.io.IOException: No such file or directory
- Solution - Check if docker is up and running!
- Problem - Error creating the Docker image on MacOS - java.io.IOException: Cannot run program “docker-credential-osxkeychain”: error=2, No such file or directory
- Solution - https://medium.com/@dakshika/error-creating-the-docker-image-on-macos-wso2-enterprise-integrator-tooling-dfb5b537b44e

### Creating Container

- mvn package

### Running Container

docker build -t jenad88/currency-exchange-service:0.0.1-SNAPSHOT .
docker run -p 8000:8000 --name=currency-exchange-service jenad88/currency-exchange-service:0.0.1-SNAPSHOT
docker run -ti --entrypoint /bin/sh --name=currency-exchange-service jenad88/currency-exchange-service:0.0.1-SNAPSHOT

docker run --name=currency-exchange-service -ti --entrypoint /bin/sh jenad88/currency-exchange-service:0.0.1-SNAPSHOT
docker exec -ti currency-exchange-service:0.0.1-SNAPSHOT /bin/sh

#### Basic
```
docker container run --publish 8000:8000 --name=currency-exchange-service jenad88/currency-exchange-service:0.0.1-SNAPSHOT
```
#### Custom Network
```
docker run --publish 8000:8000 --network currency-network --name=currency-exchange-service jenad88/currency-exchange-service:0.0.1-SNAPSHOT
```

Test API
- http://localhost:8000/api/currency-exchange-microservice/currency-exchange/from/USD/to/INR

```
docker login
docker push @@@REPO_NAME@@@/currency-exchange-service:0.0.1-SNAPSHOT
```

## Resources

- http://localhost:8000/api/currency-exchange-microservice/currency-exchange/from/USD/to/INR

```json
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65.00,
  "environmentInfo": "NA"
}
```

## H2 Console

- http://localhost:8000/api/currency-exchange-microservice/h2-console
- Use `jdbc:h2:mem:testdb` as JDBC URL


## Tables Created
```
create table exchange_value 
(
	id bigint not null, 
	conversion_multiple decimal(19,2), 
	currency_from varchar(255), 
	currency_to varchar(255), 
	primary key (id)
)
```
