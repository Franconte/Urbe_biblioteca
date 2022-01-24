FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY web/target/app.jar /opt/app
ENTRYPOINT ["java", "-Duser.timezone=Etc/GMT+4", "-jar", "/opt/app/app.jar"]
