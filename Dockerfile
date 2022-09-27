FROM maven:3.8.6-jdk-11-slim AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY src $APP_HOME/src/

COPY pom.xml $APP_HOME/
USER root
RUN mvn -f $APP_HOME/pom.xml/ clean package

# actual container
FROM adoptopenjdk/openjdk11:alpine-jre
ENV ARTIFACT_NAME=nisum-inventory-backend-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/target/$ARTIFACT_NAME ./

EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}