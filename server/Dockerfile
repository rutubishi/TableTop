FROM gradle:7-jdk11 AS build
LABEL authors="eeyan"
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle :server:buildFatJar --no-daemon

FROM openjdk:11
EXPOSE 3000:3000
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/server.jar

ENTRYPOINT ["java", "-jar", "/app/server.jar"]
