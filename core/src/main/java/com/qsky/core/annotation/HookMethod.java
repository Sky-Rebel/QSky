package com.qsky.core.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.METHOD)

@Retention (RetentionPolicy.SOURCE)

@ClassInformation
(
	author = "Sky-Rebel",
    contributor = {},
    date = "2025.02.23",
    version = "1.0.1",
    introduction = "对于一切实现Hook目标方法的方法进行标注，增加代码可读性"
)

public @interface HookMethod
{
    String introduction() default "";
}