FROM amazoncorretto:11
RUN yum -y --security update
VOLUME /tmp
ADD ./wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
ADD ./target/otel-service.jar app.jar
ADD ./target/agents/opentelemetry-javaagent.jar opentelemetry-javaagent.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=UTC", "-XX:+UseContainerSupport", "-jar", "-Xms256M", "-XshowSettings:vm", "-javaagent:/opentelemetry-javaagent.jar", "/app.jar"]