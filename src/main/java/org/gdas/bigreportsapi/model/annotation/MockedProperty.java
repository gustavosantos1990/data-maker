package org.gdas.bigreportsapi.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MockedProperty {
    int size() default 1000;
    int min() default 0;
    int max() default 999;
    boolean onlyDigits() default false;
}
