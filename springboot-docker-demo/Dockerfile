FROM openjdk:21-slim

WORKDIR /app

COPY build/libs/springboot-docker-demo-0.0.2-final.jar /app/springboot-app.jar

ENTRYPOINT ["java","-jar","springboot-app.jar"]