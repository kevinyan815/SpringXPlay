package kev.spring.springbucks.waiter.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Barista {
    String NEW_ORDERS = "new-order-output";
    String FINISHED_ORDERS = "finish-order-input";

    @Input(FINISHED_ORDERS)
    SubscribableChannel finishedOrders();

    @Output(NEW_ORDERS)
    MessageChannel newOrders();
}
