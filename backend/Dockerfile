FROM openjdk:11-jdk
COPY ./backend/build/libs/*.jar airbnb.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/airbnb.jar"]
