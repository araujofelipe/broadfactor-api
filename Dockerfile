FROM openjdk:11
COPY target/broadfactor-api-0.0.1-SNAPSHOT.jar broadfactor-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/broadfactor-api-0.0.1-SNAPSHOT.jar"]