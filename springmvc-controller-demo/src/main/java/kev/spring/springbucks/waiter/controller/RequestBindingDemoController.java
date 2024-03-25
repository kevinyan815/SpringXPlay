package kev.spring.springbucks.waiter.controller;

import kev.spring.springbucks.waiter.controller.request.ListObjectsBindRequest;
import kev.spring.springbucks.waiter.controller.request.ParamMapToFieldRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 请求体中参数绑定到数据对象的一些示例
 */
@RestController
@RequestMapping("/binding")
public class RequestBindingDemoController {
    @PostMapping("/map_test")
    // 用@RequestBody注解把请求体中的数据绑定到POJO类中
    public String  parameterMapToPojoFiled(@RequestBody ParamMapToFieldRequest request) {
        return request.toString();
    }

    @PostMapping("/bind_object_list")
    public String ListObjectsBindingValid(@RequestBody @Valid ListObjectsBindRequest request) {
        return request.toString();
    }
}


