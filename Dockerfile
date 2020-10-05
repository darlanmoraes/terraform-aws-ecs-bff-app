FROM openjdk:14-jdk-alpine
COPY ./target/*jar /usr/app/app.jar
WORKDIR /usr/app
EXPOSE 8080
EXPOSE 8081
ENTRYPOINT ["/bin/sh", "-c" , "echo 127.0.0.1 $HOSTNAME >> /etc/hosts && java -jar app.jar"]