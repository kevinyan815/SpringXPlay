package kev.spring.springbootmybatisplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("users")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    // 属性名和字段名不一样， 用@TableField 字段标明，一样的则不用
    @TableField("nick_name")
    private String nickName;

    private int age;

    private LocalDateTime createdAt;
}