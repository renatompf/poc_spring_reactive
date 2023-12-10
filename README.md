# poc_spring_reactive

## Description
POC made in [Java 21](https://www.java.com/en/) to learn the setup and the basics of the reactive programming using [Spring](https://spring.io/) and [PostgresQL](https://www.postgresql.org).

## How to run it:
In order to run this project you will need [Docker](https://www.docker.com/) and Java 17 - or higher.

In order to run this project the simpler way would be to make the following:

```shell
make run
```

This way you will start a container running the database and the app. Everything will start automatically.<br>

To stop it, you can simply do the following:
```shell
make stop
```

## How to test it:

When starting the database will be created and will be populated with some books.

### Create New Book:
```shell
localhost:8080/books
```
Body:
```json
{
  "isbn": "9781491936160",
  "title": "Kafka: The Definitive Guide",
  "publisher": "OReilly Media"
}
```

### Find All Books:
```shell
localhost:8080/books
```
### Find Book By ID (ISBN):
```shell
localhost:8080/books/9781491936160
```

### Find Book By Publisher:
```shell
localhost:8080/books/publisher?name=OReilly Media
```

### Find Book By Title:
```shell
localhost:8080/books/title?title=JavaScript: The Good Parts
```

### Find Book Where Title Contains:
```shell
localhost:8080/books/contains?content=java
```

### Delete Book By ISBN:
```shell
localhost:8080/books/9781491936160
```

## Lessons Learn:
1. When talking about Spring Reactive you refer to `Mono<T>` as a **Singular Object** and `Flux<T>` as a **List of Objects**.
2. Also, to have in mind when connecting to the database, the **URL** starts by **r2dbc** instead of **jdbc**. 
Example:
```text 
Reactive: r2dbc:postgresql://localhost:5432/database
Non-Reactive: jdbc:postgresql://localhost:5432/database
```
3. When starting you Spring service, the ddl-auto property will not work. This means that even with class annotated with `@Table` your tables will not be created automatically. For this, you'll need a migration tool, like [Flyway](https://flywaydb.org/) - The tool used in this project - or [Liquibase](https://www.liquibase.org/). [Here](https://www.baeldung.com/liquibase-vs-flyway) you have a link to see the difference between both.

