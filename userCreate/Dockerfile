FROM tomcat:latest

WORKDIR /CSC380/generatedMusic/userCreate

COPY ./target/userCreate-0.0.1-SNAPSHOT.jar ./UserCreateApplication.jar

ENTRYPOINT ["java", "-jar", "UserCreateApplication.jar"]

EXPOSE 3001