# Zoo JDBC Project

Лабораторная работа №10

## Технологии

- Java 21
- PostgreSQL
- JDBC
- HikariCP
- Maven
- Logback

## Запуск

docker start zoo-psql-lab

mvn clean compile

mvn exec:java

## Реализовано

- CRUD операции
- DAO слой
- Connection Pool (HikariCP)
- Batch Insert
- Transactions
- Rollback
- Business Queries