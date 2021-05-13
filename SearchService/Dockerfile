FROM openjdk:11.0.11-9
WORKDIR /runApp
COPY target/SearchService-0.0.1-SNAPSHOT.jar /runApp/SearchService.jar
ENTRYPOINT ["java","-jar","SearchService.jar"]
