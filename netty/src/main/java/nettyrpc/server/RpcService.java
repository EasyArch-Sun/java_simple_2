package nettyrpc.server;

import java.lang.annotation.*;

@Target(value = {ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)

public @interface RpcService {
    String value() default "";
}
