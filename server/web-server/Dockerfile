# creating build process
FROM eclipse-temurin:21-jdk

RUN mkdir app

COPY ./target/demo-0.0.1-SNAPSHOT.jar /app

WORKDIR /app

CMD [ "java", "-jar", "./demo-0.0.1-SNAPSHOT.jar" ]




