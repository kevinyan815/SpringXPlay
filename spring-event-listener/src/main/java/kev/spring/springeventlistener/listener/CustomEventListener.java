package kev.spring.springeventlistener.listener;

import kev.spring.springeventlistener.event.BaseEvent;
import kev.spring.springeventlistener.event.UserCreated;
import kev.spring.springeventlistener.event.UserCreatedFree;
import kev.spring.springeventlistener.event.UserCreatedSmart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

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
    public void handleUserCreated(UserCreatedSmart userCreated) {
        log.info("Received Event: {}, userId: {}, userName: {}", UserCreatedSmart.class,
                userCreated.getUserId(), userCreated.getUserName());
    }

    /**
     * 监听多个事件
     */
    @EventListener({UserCreatedSmart.class, UserCreated.class})
    public void handleMultiEvent() {
        log.info("收到 UserCreatedSmart 或 UserCreated");
    }

    /**
     * 监听多个事件
     * 并异步处理
     */
    @EventListener({UserCreatedSmart.class, UserCreatedFree.class})
    @Async("listener-task-pool")// 指定执行任务的线程池
    public void asyncHandleMultiEvent(BaseEvent event) {
        if (event instanceof UserCreatedSmart) {
            log.info("收到UserCreatedSmart 事件，事件的occurTime: {}, 处理线程为: {}", event.getOccurTime(), Thread.currentThread().getName());
        } else if (event instanceof UserCreatedFree){
            log.info("收到  UserCreatedFree, 处理线程为: {}", event.getOccurTime(), Thread.currentThread().getName());
        }
    }

    @EventListener({UserCreatedSmart.class})
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    // TransactionalEventListener 默认必须在事务的边界内， 发布方需要有 Transactional 一起配合使用才行
    // 上面指定订阅者在事务提交阶段执行，即保证了主体逻辑和订阅者逻辑在一个事务内执行，保证原子性。
    // 最好和事件主体逻辑在同一个线程里
    public void handleWithTransaction(UserCreatedSmart event) {
        log.info("收到UserCreatedSmart 事件，事件的occurTime: {}, 处理线程为: {}", event.getOccurTime(), Thread.currentThread().getName());
    }

}
