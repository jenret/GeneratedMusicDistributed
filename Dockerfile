FROM tomcat:latest
ENV API_PORT=3000

ENV API_HOST=localhost

WORKDIR /CSC380/generatedMusicServer

COPY ./target/swagger-spring-1.0.0.jar ./Swagger2SpringBoot.jar

ENTRYPOINT ["java", "-jar", "Swagger2SpringBoot.jar"]

EXPOSE 8080