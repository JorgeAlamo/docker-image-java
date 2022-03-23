FROM alpine:3.14 AS repository
RUN apk update
RUN apk add git
RUN git clone "https://github.com/JorgeAlamo/docker-image-java.git"

FROM maven:3.8.4-jdk-11-slim AS project
COPY --from=repository /docker-image-java/src /home/app/src
COPY --from=repository /docker-image-java/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11
COPY --from=project /home/app/target/blog-0.0.1-SNAPSHOT.jar /usr/local/lib/blog.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/blog.jar"]