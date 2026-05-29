package com.itheima.anno;

import com.itheima.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StateValidation.class})

public @interface State {
    // 校验失败提示信息
    String message() default "state参数状态不合法只能是已发布或者草稿";

    // 指定分组
    Class<?>[] groups() default {};

    // 负载 获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
