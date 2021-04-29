FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9191
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]