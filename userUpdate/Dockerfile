FROM tomcat:latest

WORKDIR /CSC380/generatedMusic/userUpdate

COPY ./target/userUpdate-0.0.1-SNAPSHOT.jar ./UserUpdateApplication.jar

ENTRYPOINT ["java", "-jar", "UserUpdateApplication.jar"]

EXPOSE 3003