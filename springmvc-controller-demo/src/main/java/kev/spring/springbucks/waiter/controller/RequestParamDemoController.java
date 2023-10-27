package kev.spring.springbucks.waiter.controller;

import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
/**
 * @RequestParam 可用于接收GET请求里查询字符串中的参数
 */
public class RequestParamDemoController {

    @GetMapping("/request-params-base")
    public String RequestParamBaseUse(@RequestParam("slogan") String slogan)
    {
        return slogan;
    }

    /**
     * @RequestParam 指定选型的用法
     * required = "true", 指定参数不传, 不传会返回400错误
     * defaultValue 指定参数的默认值
     */
    @GetMapping("request-params-option")
    public String RequestParamRequiredOption(@RequestParam(name="slogan", defaultValue = "hhhh") String slogan,
                                             @RequestParam(name="principle", required = true) String principle) {


        return slogan + principle;
    }

    /**
     * @DateTimeFormat 指定时间字符串的格式, 然后把他转换成LocalDate等时间类型
     * 如果参数格式不是pattern里指定的, 会返回 400 Bad Request 错误
     */
    @GetMapping("/request-params-with-date")
    public LocalDateTime RequestParamBaseUse(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate)
    {
        LocalDateTime startTime = LocalDateTime.of(startDate, LocalTime.MIN);
        return startTime;
    }
}
