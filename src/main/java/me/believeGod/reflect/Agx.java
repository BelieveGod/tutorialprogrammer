package me.believeGod.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author LTJ
 * @version 1.0
 * @date 2021/4/28 10:21
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Agx {
    String value() default "agx";
    String describe();
}
