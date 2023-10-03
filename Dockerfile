FROM eclipse-temurin:latest

WORKDIR /app

COPY target/online_ordering-0.0.1-SNAPSHOT.jar /app/online_ordering-0.0.1-SNAPSHOT.jar

EXPOSE 8080
EXPOSE 5005

#java -jar online_ordering-0.0.1-SNAPSHOT.jar

#mysql -u root -p -h database -D online_ordering_db

#RUN apt update -y && \
#    apt install -y mysql-client && \
#    rm -rf /var/lib/apt/lists/*

#ENTRYPOINT ["tail", "-f", "/dev/null"]

ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n"

CMD ["java", "-jar", "online_ordering-0.0.1-SNAPSHOT.jar"]
