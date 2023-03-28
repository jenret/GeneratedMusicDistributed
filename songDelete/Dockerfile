FROM tomcat:latest

WORKDIR /CSC380/generatedMusic/songDelete

COPY ./target/songDelete-0.0.1-SNAPSHOT.jar ./SongDeleteApplication.jar

ENTRYPOINT ["java", "-jar", "SongDeleteApplication.jar"]

EXPOSE 3005