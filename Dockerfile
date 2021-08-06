# Dockerfile也可以不放在项目目录下，通过 -f 指定Dockerfile的位置，比如在项目根下执行以下命令 
# docker build -t <some tag> -f <dirPath/Dockerfile> .

FROM registry.cn-beijing.aliyuncs.com/docker-study-lab/aliyun-maven:0.0.1 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src

WORKDIR /build/
# mount a host directory as .m2 storage for contianer 
VOLUME /root/.m2

RUN mvn clean package -Dmaven.test.skip=true --quiet

FROM openjdk:8-jre


COPY --from=MAVEN_BUILD /build/target/*.jar /app/application.jar

ENTRYPOINT ["java", "-jar", "/app/application.jar"]
