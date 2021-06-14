package kev.spring.springbucks;

import io.lettuce.core.ReadFrom;
import kev.spring.springbucks.converter.BytesToMoneyConverter;
import kev.spring.springbucks.converter.MoneyToBytesConverter;
import kev.spring.springbucks.model.Coffee;
import kev.spring.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
public class SpringBucksApplication implements ApplicationRunner {
    @Autowired
    private CoffeeService coffeeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBucksApplication.class, args);
    }


    @Bean
    public RedisCustomConversions redisCustomConversions() {
        return new RedisCustomConversions(
                Arrays.asList(new MoneyToBytesConverter(), new BytesToMoneyConverter()));
    }


    @Bean
    public RedisTemplate<String, Coffee> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Coffee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public LettuceClientConfigurationBuilderCustomizer customizer() {
        return builder -> builder.readFrom(ReadFrom.MASTER_PREFERRED);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 使用RedisTemplate读写Redis
//        useRedisTemplate();
        // 使用Redis Repository 读写Redis
        useRedisRepository();
    }

    private void useRedisTemplate() {
        Optional<Coffee> c = coffeeService.findOneCoffee("mocha");
        log.info("Coffee {}", c);

        for (int i = 0; i < 5; i++) {
            c = coffeeService.findOneCoffee("mocha");
        }

        log.info("Value from Redis: {}", c);
    }

    private void useRedisRepository() {
        Optional<Coffee> c = coffeeService.findSimpleCoffeeFromCache("mocha");
        log.info("Coffee {}", c);

        for (int i = 0; i < 5; i++) {
            c = coffeeService.findSimpleCoffeeFromCache("mocha");
        }

        log.info("Value from Redis: {}", c);
    }
}