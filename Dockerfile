FROM maven:3.8.6-openjdk-18-slim AS TEMP_BUILD_IMAGE
COPY src /usr/app/src/
COPY pom.xml /usr/app/
RUN mvn -f /usr/app/pom.xml clean package -DskipTests

# actual container
FROM adoptopenjdk/openjdk11:alpine
ENV ARTIFACT_NAME=nisum-inventory-api-0.0.1-SNAPSHOT.jar

COPY --from=TEMP_BUILD_IMAGE /usr/app/target/$ARTIFACT_NAME /usr/app/
EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}
