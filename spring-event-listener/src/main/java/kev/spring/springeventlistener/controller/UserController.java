package kev.spring.springeventlistener.controller;

import kev.spring.springeventlistener.publisher.CustomEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private CustomEventPublisher customEventPublisher;
    @GetMapping("/user-create")
    public String createUser() {
        customEventPublisher.publishUserCreatedEvent(this, 1, "Keivn");
        return "OK";
    }

    @GetMapping("/user-create-smart")
    public String createUserSmart() {
        customEventPublisher.publishUserCreatedSmartEvent(1, "Keivn");
        return "OK";
    }
}
