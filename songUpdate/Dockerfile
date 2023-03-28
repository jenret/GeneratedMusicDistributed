FROM tomcat:latest

WORKDIR /CSC380/generatedMusic/songUpdate

COPY ./target/songUpdate-0.0.1-SNAPSHOT.jar ./SongUpdateApplication.jar

ENTRYPOINT ["java", "-jar", "SongUpdateApplication.jar"]

EXPOSE 3006