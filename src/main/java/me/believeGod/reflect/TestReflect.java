package me.believeGod.reflect;

import me.believeGod.template.Fish;

import java.lang.annotation.Annotation;

/**
 * @ClassName TestReflect
 * @Description TODO
 * @Author Tim
 * @Date 2020/6/3 11:53
 * @Version 1.0
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> fishClass=Class.forName("me.believeGod.template.Fish");
        Class<Fish> fishClass1 = Fish.class;
        Fish fish=new Fish();
        Class<? extends Fish> fishClass2 = fish.getClass();

        Annotation[] annotations = fishClass.getAnnotations();
        ClassLoader classLoader = fishClass.getClassLoader();
        Class<?> componentType = fishClass.getComponentType();
        fishClass.getConstructors();



    }
}
