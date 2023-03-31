FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

FROM openjdk:17-alpine

COPY --from=build /target/RESTfulAPI_Workspace_Management-0.0.1-SNAPSHOT.jar wic_rvce.jar

ENTRYPOINT ["java","-jar","wic_rvce.jar"]