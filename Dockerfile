FROM eclipse-temurin:18-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar changer-1.0.jar
ENTRYPOINT ["java","-jar","/changer-1.0.jar"]
EXPOSE 8080