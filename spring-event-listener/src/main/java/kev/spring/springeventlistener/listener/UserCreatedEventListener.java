package kev.spring.springeventlistener.listener;

import kev.spring.springeventlistener.event.UserCreated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCreatedEventListener implements ApplicationListener<UserCreated> {
    /**
     * Spring 4 以前，事件的监听者 EventListener 必须实现 ApplicationListener 接口
     * 实现该接口的 onApplicationEvent 方法
     * @param userCreated
     */
    @Override
    public void onApplicationEvent(UserCreated userCreated) {
        log.info("Received Event: {}, eventSource: {}, userId: {}, userName: {}", UserCreated.class, userCreated.getSource().getClass().getName(),
                userCreated.getUserId(), userCreated.getUserName());
    }
}
