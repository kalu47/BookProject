FROM openjdk:11.0.11-9
WORKDIR /runApp
COPY target/BookService-0.0.1-SNAPSHOT.jar /runApp/BookService.jar
ENTRYPOINT ["java","-jar","BookService.jar"]
