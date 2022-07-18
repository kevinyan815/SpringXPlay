package kev.spring.springeventlistener.controller;

import kev.spring.springeventlistener.publisher.CustomEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
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

    @GetMapping("/user-create-async")
    public String createUserAsync() {
        customEventPublisher.publishUserCreatedSmartEvent(1, "Keivn");
        return "OK";
    }

    @GetMapping("/user-create-trans")
    @Transactional
    public String createUserWithInTransaction() {
        log.info("发布者所在线程：{}", Thread.currentThread().getName());
        customEventPublisher.publishUserCreatedSmartEvent(1, "Keivn");
        return "OK";
    }


}
