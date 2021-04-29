FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9003
ADD target/CollateralLoan-RiskAssessment-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]