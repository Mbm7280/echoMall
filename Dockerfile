FROM openjdk:8-jdk-slim
LABEL maintainer=echo

COPY *.jar   /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

docker build -t mall-demo:v1.0 .
docker run -d -p 8080:8080 --name mallAapp mall-demo:v1.0