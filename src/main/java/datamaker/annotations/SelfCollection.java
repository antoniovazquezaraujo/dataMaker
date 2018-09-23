package datamaker.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface SelfCollection {
    public int minDepth() default 1;

    public int maxDepth() default 3;

    public int minSize() default 1;

    public int maxSize() default 5;
}