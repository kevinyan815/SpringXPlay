package kev.spring.springbucks.waiter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

// 全局的Controller AOP Advice
@RestControllerAdvice
public class GlobalControllerAdvice {
    // ExceptionHandler 指定要处理的异常类，可以写多个
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> validationExceptionHandler(ValidationException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("message", exception.getMessage());
        return map;
    }
}

