package kev.spring.springeventlistener.publisher;


import kev.spring.springeventlistener.event.UserCreated;
import kev.spring.springeventlistener.event.UserCreatedSmart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishUserCreatedEvent(Object source, int userId, String userName) {
        this.applicationEventPublisher.publishEvent(new UserCreated(source, userId, userName));
    }

    public void publishUserCreatedSmartEvent(int userId, String userName) {
        this.applicationEventPublisher.publishEvent(new UserCreatedSmart(userId, userName));
    }
}
