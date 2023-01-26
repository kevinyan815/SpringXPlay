package kev.spring.springeventlistener.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
/**
 * Spring 4.2 以前自定义事件，必须继承自 ApplicationEvent 才行
 * Spring 4.2 后，不再需要这种方式，任何类对象都可以作为事件对象，被Spring 的 ApplicationEventPublisher 发布出去。
 */
public class UserCreated extends ApplicationEvent {

    private int userId;

    private String userName;

    public UserCreated(Object source, int userId, String userName) {
        super(source);
        this.setUserId(userId);
        this.setUserName(userName);
    }
}
