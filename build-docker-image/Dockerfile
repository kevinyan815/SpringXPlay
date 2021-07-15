FROM java:8
EXPOSE 8080
# ARG 指令定义参数名称及其默认值。完整的格式是 ARG <参数名>[=<默认值>], 默认值可省略
# 该默认值可以在构建命令 docker build 中用 --build-arg <参数名>=<值> 来覆盖。
# 这个参数的值在构建时会使用用POM文件里<buildArgs>指定的值
ARG JAR_FILE
ADD target/${JAR_FILE} /waiter-service.jar
ENTRYPOINT ["java", "-jar","/waiter-service.jar"]