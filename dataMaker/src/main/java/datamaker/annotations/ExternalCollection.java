package datamaker.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
// @Target(ElementType.METHOD)

public @interface ExternalCollection {
    Class<?> type() default Object.class;

    public int minDepth() default 1;

    public int maxDepth() default 3;

    public int minSize() default 1;

    public int maxSize() default 5;
}