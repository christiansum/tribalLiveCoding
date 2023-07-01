FROM openjdk:17-jdk-alpine
COPY target/chistes-1.jar chistesApp.jar
ENV JAVA_OPTS="-XX:PermSize=1024m -XX:MaxPermSize=512m"
EXPOSE 80

ENTRYPOINT ["java", "-Xms1024M ", "-Xmx1024M", "-jar","chistesApp.jar"]