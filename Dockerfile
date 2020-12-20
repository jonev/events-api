FROM openjdk:8-jdk-alpine as builder
COPY . /app
WORKDIR /app
RUN ./gradlew build --no-daemon

FROM openjdk:8-jre-alpine
ENV spring_profiles_active=prod
RUN mkdir /app
RUN addgroup -S prodgroup && adduser -S prod -G prodgroup
COPY --from=builder /app/build/libs/events-api-0.0.1-SNAPSHOT.jar /app/app.jar
USER prod
CMD ["java","-jar","/app/app.jar"]