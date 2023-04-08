FROM eclipse-temurin:18-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar FastRename-1.0.jar
ENTRYPOINT ["java","-jar","/FastRename-1.0.jar"]
EXPOSE 8080