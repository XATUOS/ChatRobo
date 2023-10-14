package dev.xatuos.chatrobo.api.web;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = RequestMethod.DELETE)
public @interface DeleteMapping {
    String name() default "";

    String[] value() default {};
}
