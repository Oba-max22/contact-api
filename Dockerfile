FROM openjdk:17
WORKDIR /app
EXPOSE 9000
COPY target/contact-0.0.1-SNAPSHOT.jar /app/
RUN bash -c 'touch /app/contact-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java", "-jar","/app/contact-0.0.1-SNAPSHOT.jar"]