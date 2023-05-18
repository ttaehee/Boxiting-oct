FROM openjdk:17-oracle

WORKDIR /usr/src/app

ARG JAR_FILE=./build/libs/*.jar

COPY ${JAR_FILE} ./build/libs/dust-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "./build/libs/dust-0.0.1-SNAPSHOT.jar"]