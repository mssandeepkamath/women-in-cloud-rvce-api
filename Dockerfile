FROM openjdk:17-alpine

COPY ./target/RESTfulAPI_Workspace_Management-0.0.1-SNAPSHOT.jar wic_rvce.jar

ENTRYPOINT ["java","-jar","wic_rvce.jar"]