package kev.spring.springeventlistener.event;

import java.time.LocalDateTime;

public class BaseEvent {
    private LocalDateTime occurTime = LocalDateTime.now();

    public LocalDateTime getOccurTime() {
        return occurTime;
    }
}
