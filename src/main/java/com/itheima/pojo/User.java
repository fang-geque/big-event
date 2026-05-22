package com.itheima.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
// lombok 在编译阶段，为实体类自动生成setter getter toString方法
// pom文件中引入依赖 在实体类上添加注解
@Data
public class User {
    @NotNull
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore // 忽略该字段
    private String password;//密码

    @NotNull
    @Pattern(regexp = "^\\S{5,16}$")
    private String nickname;//昵称
    @NotNull
    @Email
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
