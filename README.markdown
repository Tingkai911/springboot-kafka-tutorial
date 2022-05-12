Springboot kafka tutorials:
- https://www.confluent.io/blog/apache-kafka-spring-boot-application/
- https://youtube.com/playlist?list=PLGRDMO4rOGcNLwoack4ZiTyewUcF6y6BU
- https://kafka.apache.org/quickstart
- https://docs.spring.io/spring-kafka/reference/html/
- https://howtodoinjava.com/kafka/multiple-consumers-example/

### Description 
Demo springboot kafka project

### Dependencies
Run zookeeper and kafka in docker using the following docker-compose file and run the command "docker-compose -f docker-compose.yml up -d"
```
version: '3'

services:
    zookeeper:
        image: wurstmeister/zookeeper
        container_name: zookeeper
        ports:
            - "2181:2181"
        restart: unless-stopped
kafka:
    image: wurstmeister/kafka
    container_name: kafka
    ports:
        - "9092:9092"
    environment:
        KAFKA_ADVERTISED_HOST_NAME: localhost
        KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    restart: unless-stopped
```