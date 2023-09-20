FROM eclipse-temurin:latest

WORKDIR /app

COPY target/online_ordering-0.0.1-SNAPSHOT.jar /app/online_ordering-0.0.1-SNAPSHOT.jar

#EXPOSE 8080

#CMD ["java", "-jar", "online_ordering-0.0.1-SNAPSHOT.jar"]

RUN apt update -y && \
    apt install -y mysql-client && \
    rm -rf /var/lib/apt/lists/*

ENTRYPOINT ["tail", "-f", "/dev/null"]