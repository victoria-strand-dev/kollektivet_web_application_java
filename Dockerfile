FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

EXPOSE 8081

CMD ["java", "-jar", "target/KOLLEKTIVET-0.0.1-SNAPSHOT.jar"]