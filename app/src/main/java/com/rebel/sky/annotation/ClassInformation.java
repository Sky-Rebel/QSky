package com.rebel.sky.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/* -------------------->
 * 他朝若是同淋雪，此生也算共白头
 * If someday we stand beneath the same falling snow, 
 * Then this life, too, has known our hair turned white together.
 * <-------------------- */

@Target(ElementType.TYPE)

@Retention(RetentionPolicy.SOURCE)

@ClassInformation
(
	author = "Sky-Rebel",
    contributor = {},
    date = "2025.02.23",
    version = "1.0.1",
    introduction = "对于类的信息以注解的形式进行标注."
)

public @interface ClassInformation
{
    String author() default "Sky-Rebel";
    
    String[] contributor() default {};

    String date() default "NULL";
    
    /**
    * @deprecated
    * 暂时没有明确的版本更新策略，也许会于未来彻底废弃吧.
    */
    @Deprecated
    String version() default "1.0.1";

    String introduction() default "NULL";
}