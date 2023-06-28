package com.example.spring_basic.config;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//模仿requestMapping/getMapping注解，自定义一个注解，用于用户不登录就可以访问的接口。在JWT拦截器中判断方法上是否有这个注解，如果有就放行
public @interface AuthAccess {

}
