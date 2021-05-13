FROM openjdk:11.0.11-9
WORKDIR /runApp
COPY target/RecomendationService-0.0.1-SNAPSHOT.jar /runApp/RecomendationService.jar
ENTRYPOINT ["java","-jar","RecomendationService.jar"]
