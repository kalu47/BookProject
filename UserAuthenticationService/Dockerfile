FROM openjdk:11.0.11-9
WORKDIR /runApp
COPY target/UserAuthenticationService-0.0.1-SNAPSHOT.jar /runApp/UserAuthentication.jar
ENTRYPOINT ["java","-jar","UserAuthentication.jar"]
