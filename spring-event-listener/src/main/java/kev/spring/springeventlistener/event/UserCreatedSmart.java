package kev.spring.springeventlistener.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Spring 4.2 后，事件类不必再继承 ApplicationEvent，支持发布任何任意事件
 * (也就是说，一个不一定是从ApplicationEvent扩展而来的对象)的能力。
 * 当这样一个对象被发布时会被包装在一个事件中。
 *
 * 调用 ApplicationEventPublisher#publishEvent(event) 发布事件时，
 * 如果event本身继承了 ApplicationEvent正常发送，如果 event 没有继承 ApplicationEvent 则将被包装成
 * PayloadApplicationEvent 来发送。
 *
 */
@Data
@AllArgsConstructor
public class UserCreatedSmart {
    private int userId;

    private String userName;
}
