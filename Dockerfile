FROM maven:3.8.6-openjdk-18-slim AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY src $APP_HOME/src/
COPY pom.xml $APP_HOME/
RUN mvn -f $APP_HOME/pom.xml clean package -DskipTests

# actual container
FROM adoptopenjdk/openjdk11:alpine-jre
ENV ARTIFACT_NAME=nisum-inventory-api-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/target/$ARTIFACT_NAME /usr/app/
EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}
# ENTRYPOINT []
