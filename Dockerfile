## ====== Build Image ====== ##
FROM maven:3.9.5-amazoncorretto-21 AS build_image

WORKDIR /app

COPY pom.xml .
RUN mvn -e -B dependency:resolve

COPY src ./src
RUN mvn package -DskipTests

## ====== Deploy Image ====== ##
FROM amazoncorretto:21.0.1 as release_image

# Workdir creation
WORKDIR /app

COPY --from=build_image /app/target/poc_spring_reactive.jar .

# Container entrypoint
CMD [ "java", "-jar", "./poc_spring_reactive.jar" ]