FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

FROM openjdk:17-alpine

COPY ./target/RESTfulAPI_Workspace_Management-0.0.1-SNAPSHOT.jar wic_rvce.jar

ENTRYPOINT ["java","-jar","wic_rvce.jar"]