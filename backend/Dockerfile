# 1. Imagen
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app

# 2. copiar pom maven
COPY pom.xml ./
RUN mvn dependency:go-offline

# 3. Copia y compila el src code
COPY src ./src
RUN mvn package -DskipTests

# 4. Imagen de Java para ejecutar app
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# 5. Copiar JAR compilado
COPY --from=build /app/target/*.jar app.jar

# 6. Puerto spring
EXPOSE 8080

# 7. Comando arranque
ENTRYPOINT ["java", "-jar", "app.jar"]