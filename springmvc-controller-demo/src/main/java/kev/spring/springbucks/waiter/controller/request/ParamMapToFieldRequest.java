package kev.spring.springbucks.waiter.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ParamMapToFieldRequest {
    // 默认把和字段名字一样的属性映射到字段上,
    // 如果参数与字段名不一样需要用@JsonProperty进行标注(Spring 解析JSON用的是Jackson解析请求，所以这里使用它的@JsonProperty注解)
    @JsonProperty("start_date")
    // 指定把请求中的字符串参数值转换成LocalDate对象
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate startDate;
    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate EndDate;
    @JsonProperty("company_sign")
    private String CompanySign;
}
