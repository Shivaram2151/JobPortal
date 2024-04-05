FROM maven:3.6.3-openjdk-8 As build
COPY . .

RUN mvn clean package -DskipTests

FROM maven:3.8.3-openjdk-8-slim
COPY --from=build /target/jobportal-0.0.1-SNAPSHOT.jar jobportal.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar","jobportal.jar" ]