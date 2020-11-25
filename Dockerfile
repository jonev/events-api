FROM openjdk:8-jdk-alpine as builder
COPY . /app
WORKDIR /app
RUN ./gradlew build --no-daemon

FROM openjdk:8-jdk-alpine
COPY --from=builder /app/build/libs/events-api-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java","-jar","/app/app.jar"]