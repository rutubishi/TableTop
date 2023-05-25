# jdk image
FROM openjdk:11
# create new app folder
RUN mkdir /app
# default working env
WORKDIR /app
# copy all files
COPY . /app
# build the server
RUN ./gradlew buildFatJar --no-daemon
# expose port to network
EXPOSE 3000:3000
# run jar file
ENTRYPOINT ["java", "-jar", "./server/build/libs/server-all.jar"]
