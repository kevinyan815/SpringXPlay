package kev.spring.springeventlistener.listener;

import kev.spring.springeventlistener.event.UserCreated;
import kev.spring.springeventlistener.event.UserCreatedSmart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Spring 4.2 以后可以使用 @EventListener 注解在托管 Bean 的任何方法上注册事件监听器。
 * 同时可以配和 @Async 使用，实现事件的异步处理
 */
@Slf4j
@Component
public class CustomEventListener {


    /**
     * 监听单个事件
     * @param userCreated
     */
    @EventListener(UserCreatedSmart.class)
    public void listen(UserCreatedSmart userCreated) {
        log.info("Received Event: {}, userId: {}, userName: {}", UserCreatedSmart.class,
                userCreated.getUserId(), userCreated.getUserName());
    }

    /**
     * 监听多个事件
     */
    @EventListener({UserCreatedSmart.class, UserCreated.class})
    public void handleContextStart() {
        log.info("收到 UserCreatedSmart 或 UserCreated");
    }
}
