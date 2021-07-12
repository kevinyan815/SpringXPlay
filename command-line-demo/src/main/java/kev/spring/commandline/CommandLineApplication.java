package kev.spring.commandline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CommandLineApplication {

    public static void main(String[] args) {
        // 方式一. 以编程的方式禁用Web容器
        new SpringApplicationBuilder(CommandLineApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        // 方式二. 根据 application.properties 里的配置来决定 WebApplicationType
//		SpringApplication.run(CommandLineApplication.class, args);
    }
}
