FROM openjdk:8-jdk

COPY . /app
WORKDIR /app

RUN ./gradlew build

CMD ["java", "-jar", "build/libs/spring-boot-hello-world-0.1.0.jar"]
