FROM tomcat:latest

WORKDIR /CSC380/generatedMusic/songCreate

COPY ./target/songCreate-0.0.1-SNAPSHOT.jar ./SongCreateApplication.jar

ENTRYPOINT ["java", "-jar", "SongCreateApplication.jar"]

EXPOSE 3004