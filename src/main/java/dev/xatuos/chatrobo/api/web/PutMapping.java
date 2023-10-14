package dev.xatuos.chatrobo.api.web;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = RequestMethod.PUT)
public @interface PutMapping {
    String name() default "";

    String[] value() default {};
}
