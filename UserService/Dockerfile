FROM openjdk:11.0.11-9
WORKDIR /runApp
COPY target/UserService-0.0.1-SNAPSHOT.jar /runApp/UserService.jar
ENTRYPOINT ["java","-jar","UserService.jar"]
