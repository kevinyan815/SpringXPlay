package kev.spring.springeventlistener.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreatedFree extends BaseEvent{

    private String nickName;

}
