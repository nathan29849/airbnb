FROM openjdk:11-jdk
COPY ./backend/build/libs/*.jar airbnb.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/airbnb.jar", "--spring.datasource.username=$MYSQL_DATABASE_USERNAME", "--spring.datasource.username=$MYSQL_DATABASE_URL", "--spring.datasource.username=$MYSQL_DATABASE_PASSWORD"]
