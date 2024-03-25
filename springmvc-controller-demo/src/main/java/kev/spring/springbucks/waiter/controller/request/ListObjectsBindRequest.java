package kev.spring.springbucks.waiter.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ListObjectsBindRequest {

    @Valid
    @NotEmpty
    private List<Item> list;
    @Data
    public static class Item {
        @NotEmpty
        private String company;
        private String skuName;
        @NotNull
        private Long userId;
        @NotEmpty
        private String policyNo;
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private LocalDateTime createTime;
    }
}
