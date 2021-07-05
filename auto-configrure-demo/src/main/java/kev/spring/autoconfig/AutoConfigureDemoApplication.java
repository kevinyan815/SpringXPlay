package kev.spring.autoconfig;

import kev.spring.greeting.GreetingApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoConfigureDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoConfigureDemoApplication.class, args);
    }

//    @Bean
//    public GreetingApplicationRunner greetingApplicationRunner() {
//        return new GreetingApplicationRunner("NiuNiu");
//    }

}