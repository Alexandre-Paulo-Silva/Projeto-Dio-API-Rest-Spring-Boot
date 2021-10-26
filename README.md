# Projeto-Dio-API-Rest-Spring-Boot


# Projeto Spring Boot Rest Test de Conexao Com Docker 


# Para Mais Detalhes do projeto va ate o repositorio original: [github.com/andrelugomes/digital-innovation-one/tree/master/cities-api](https://github.com/andrelugomes/digital-innovation-one/tree/master/cities-api) 


# Cities API

## Requirements

* Linux
* Git
* Java 8
* Docker
* IntelliJ Community


## DataBase

### Postgres

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### Populate

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

### dependencies

### Build.gradle


```shell script
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web:2.5.5'
	implementation 'com.vladmihalcea:hibernate-types-52:2.9.8'
	implementation 'org.postgresql:postgresql'
	implementation 'io.openliberty.features:com.ibm.websphere.appserver.jsfProvider-2.2.0.Container:21.0.0.9'
	implementation 'io.openliberty.features:com.ibm.websphere.appserver.jsfProvider-2.3.0.Container:21.0.0.9'
	implementation 'commons-io:commons-io:20030203.000550'
	implementation 'org.hamcrest:hamcrest-all:1.3'
	implementation 'io.openliberty.features:jpaContainer-2.2:21.0.0.9'
	implementation 'io.openliberty.features:jpaContainer-2.1:21.0.0.9'
	implementation 'org.rnorth.test-containers:test-containers:0.9.5'
	implementation 'com.yahoo.gondola.containers:containers:0.2.7'
	implementation 'org.testifyproject.container:container:0.9.3'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation "org.testcontainers:testcontainers:1.16.0"
	implementation platform('org.testcontainers:testcontainers-bom:1.16.0') //import bom
	testImplementation('org.testcontainers:postgresql:1.16.0')
    testImplementation('io.mockk:mockk:1.10.4')
	testImplementation('org.ninja-squad:springmockk:3.0.1')
    testImplementation('org.testcontainers:testcontainers:1.16.0')
	testImplementation('org.testcontainers:postgresql:1.16.0')
    testImplementation "org.testcontainers:junit-jupiter:1.16.0"
    implementation ('org.springframework.boot:spring-boot-starter-data-jdbc')
    testImplementation "org.testcontainers:spock:1.16.0"//no version specified
    
```


### Configuracão conexao com PostgreSQL

### application.properties

```shell script

spring.datasource.url=jdbc:postgresql://localhost:5432/cities
spring.datasource.username=postgres_user_city
spring.datasource.password=super_password
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Access

```shell script
docker exec -it cities-db /bin/bash

psql -U postgres_user_city cities
```

### Query Earth Distance

Point
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cube
```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)

+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver
+ Testcontainers 

### Spring Data

* [jpa.query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)






```shell script
wget https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
