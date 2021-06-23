package kev.spring.springbucks.waiter.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

// 通过给异常类添加ResponseStatus注解，让Spring处理这个异常的输出
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
@AllArgsConstructor
public class FormValidationException extends RuntimeException {
    private BindingResult result;
}
