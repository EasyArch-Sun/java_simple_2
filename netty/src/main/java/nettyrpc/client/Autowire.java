package nettyrpc.client;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Documented
public @interface Autowire {
}
