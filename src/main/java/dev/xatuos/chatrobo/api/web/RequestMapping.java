package dev.xatuos.chatrobo.api.web;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String name() default "";

    String[] value() default {};

    RequestMethod[] method() default {};
}
