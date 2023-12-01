FROM amazoncorretto:17.0.8-alpine3.18
VOLUME /tmp
EXPOSE 8000
ARG JAR_FILE
COPY target/*.jar app.jar
# ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]