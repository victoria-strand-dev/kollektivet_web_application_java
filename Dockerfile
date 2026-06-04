FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN ./mvnw package -DskipTests

EXPOSE 8081

CMD ["java", "-jar", "target/KOLLEKTIVET-0.0.1-SNAPSHOT.jar"]