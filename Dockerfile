# STAGE 1
FROM amazoncorretto:17.0.8-alpine3.18 as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# STAGE 2
FROM amazoncorretto:17.0.8-alpine3.18
WORKDIR application
VOLUME /tmp
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

#ENV JAVA_OPTS=""
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
#docker run -p 9000:9000 myorg/myapp --server.port=9000
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]