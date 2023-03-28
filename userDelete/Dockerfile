FROM tomcat:latest

WORKDIR /CSC380/generatedMusic/userDelete

COPY ./target/userDelete-0.0.1-SNAPSHOT.jar ./UserDeleteApplication.jar

ENTRYPOINT ["java", "-jar", "UserDeleteApplication.jar"]

EXPOSE 3002