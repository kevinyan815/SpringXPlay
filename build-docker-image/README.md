### Docker File

```dockerfile
FROM java:8
EXPOSE 8080
ARG JAR_FILE
ADD target/${JAR_FILE} /waiter-service.jar
ENTRYPOINT ["java", "-jar","/waiter-service.jar"]
```

#### 说明：

- ARG 指令定义参数名称及其默认值。完整的格式是 ARG <参数名>[=<默认值>], 默认值可省略
- 该默认值可以在构建命令 docker build 中用 --build-arg <参数名>=<值> 来覆盖。
- 这个参数的值在构建时会使用用POM文件里<buildArgs>指定的值

### dockerfile-maven-plugin

#### Maven依赖

```xml

<build>
    <plugins>
        <plugin>
            <groupId>com.spotify</groupId>
            <artifactId>dockerfile-maven-plugin</artifactId>
            <version>1.4.10</version>
            <executions>
                <execution>
                    <id>default</id>
                    <goals>
                        <goal>build</goal>
                        <goal>push</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
                <!--registry 的格式是<username>/<repository-name>, 默认往docker hub上push, 可以设置往私有仓库上push-->
                <!--往私有仓库push镜像： <repository>private.registry.com/${docker.image.prefix}/${project.artifactId}</repository> -->
                <repository>${docker.image.prefix}/${project.artifactId}</repository>
                <tag>${project.version}</tag>
                <useMavenSettingsForAuth>true</useMavenSettingsForAuth>
                <buildArgs>
                    <JAR_FILE>${project.build.finalName}.jar</JAR_FILE>
                </buildArgs>
            </configuration>
        </plugin>
    </plugins>
</build>
```

#### 说明

- registry 的格式是<username>/<repository-name>, 默认往docker hub上push, 可以设置往私有仓库上push
- 往私有仓库push镜像： `<repository>private.registry.com/${docker.image.prefix}/${project.artifactId}</repository>`
- （看不懂的话，结合整个POM文件看）

### 操作步骤

- mvn clean package -Dmaven.test.skip=true 打jar包和Docker镜像

- mvn dockerfile:push
    - `<useMavenSettingsForAuth>true</useMavenSettingsForAuth>` 要加上
    - Maven的设置里要加上docker仓库的认证信息
    ```xml
    <server>
        <id>docker.io</id>
        <username>xxxxx</username>
        <password>xxxxxx</password>
    </server>
    ```
  
### Docker 多阶段打包镜像
也可以不依赖插件，通过Docker的多阶段打包，先用一个maven镜像把项目打包，
再把打包好的jar文件拷贝到jre镜像里


#### 提醒：如果使用多阶段打包记得把POM文件里的 dockerfile-maven-plugin 去掉

```dockerfile
# Dockerfile也可以不放在项目目录下，通过 -f 指定Dockerfile的位置，比如在项目根下执行以下命令 
# docker build -t <some tag> -f <dirPath/Dockerfile>  --progress plain .

FROM maven:3.6.2-jdk-8-slim AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src

WORKDIR /build/

RUN mvn clean package -Dmaven.test.skip=true --quiet

FROM openjdk:8-jre


COPY --from=MAVEN_BUILD /build/target/*.jar /app/application.jar

ENTRYPOINT ["java", "-jar", "/app/application.jar"]

```