package dev.xatuos.chatrobo.api.web;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = RequestMethod.POST)
public @interface PostMapping {
    String name() default "";

    String[] value() default {};
}
