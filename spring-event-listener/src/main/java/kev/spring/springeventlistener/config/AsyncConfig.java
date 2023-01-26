package kev.spring.springeventlistener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {
    private int corePoolSize = 10;
    private int maxPoolSize = 200;
    private int queueCapacity = 10;

    @Bean("listener-task-pool")
    //给Bean取个的名字，默认Bean的名字是方法名， 即taskExecutor，线程池的名字会跟Bean的名字保持一致
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}
