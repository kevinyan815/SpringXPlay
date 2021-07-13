
### 1. 认识可执行 Jar

- Jar 描述，META-INF/MANIFEST.MF
- Spring Boot Loader，org/springframework/boot/loader 
- 项⽬自己的内容，放在 BOOT-INF/classes
- 项⽬依赖的jar，放在，BOOT-INF/lib
- Jar包里不包含 JDK / JRE


### 2. 如何找到程序入口
- Jar 的启动类
    - MANIFEST.MF
        - Main-Class: org.springframework.boot.loader.JarLauncher
- 项目的主类 
    - Start-Class指定 带有 @SpringApplication 注解的类
    - MANIFEST.MF
        - Start-Class: xxx.yyy.zzz （类的全限定名）



### 3. 省略java -jar 命令执行，需POM添加设置

```xml
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
<!--				打出可直接执行的Jar包 （不需要用java -jar 命令运行）-->
				<configuration>
					<executable>true</executable>
				</configuration>
			</plugin>
		</plugins>
	</build>
```

### 4. 打包命令

```shell
# -Dmaven.test.skip-true 表示跳过测试
mvn clean package -Dmaven.test.skip-true
```
