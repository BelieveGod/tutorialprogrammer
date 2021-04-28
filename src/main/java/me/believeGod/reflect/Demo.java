package me.believeGod.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author LTJ
 * @version 1.0
 * @date 2021/4/28 10:34
 */
public class Demo {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
                   InstantiationException {
        Class<?> flyCarClass = Class.forName("me.believeGod.reflect.FlyCar");
        System.out.println("flyCarClass.getName() = " + flyCarClass.getName());
        // 类加载器名字
        System.out.println("flyCarClass.getClassLoader().getName() = " + flyCarClass.getClassLoader().getName());

        Annotation[] annotations = flyCarClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation.annotationType().getClass().getName() = " +
                               annotation.annotationType().getClass().getName());
            System.out.println("annotation = " + annotation);
            System.out.println("annotation.getClass().getName() = " + annotation.getClass().getName());
            System.out
                    .println("annotation.getClass().getCanonicalName() = " + annotation.getClass().getCanonicalName());
        }

        if (flyCarClass.isAnnotationPresent(Agx.class)) {
            Agx agx = flyCarClass.getAnnotation(Agx.class);
            System.out.println("agx.value() = " + agx.value());
            System.out.println("agx.describe() = " + agx.describe());
        }

        String[] b = new String[4];
        System.out.println("b.getClass().getName() = " + b.getClass().getName());
        System.out.println("b.getClass().getComponentType() = " + b.getClass().getComponentType());

        Constructor<?> constructor = flyCarClass.getConstructor();
        FlyCar flyCar = (FlyCar)constructor.newInstance();
        flyCar.fly();

        System.out.println("flyCarClass.getCanonicalName() = " + flyCarClass.getCanonicalName());
        Field[] declaredFields = flyCarClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(
                    "declaredField.getGenericType().getTypeName() = " + declaredField.getGenericType().getTypeName());
            System.out.println("declaredField.getName() = " + declaredField.getName());
        }

        Field[] fields = flyCarClass.getFields();
        for (Field field : fields) {
            System.out.println("field.getGenericType().getTypeName() = " + field.getGenericType().getTypeName());
            System.out.println("field.getName() = " + field.getName());
        }

        Method[] methods = flyCarClass.getMethods();
        for (Method method : methods) {
            System.out.println(
                    "method.getDeclaringClass().getCanonicalName() = " + method.getDeclaringClass().getCanonicalName());
            System.out.println("method.getName() = " + method.getName());
        }

        Method[] declaredMethods = flyCarClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod.getDeclaringClass().getCanonicalName() = " +
                               declaredMethod.getDeclaringClass().getCanonicalName());
            System.out.println("declaredMethod.getName() = " + declaredMethod.getName());
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("parameterType.getName() = " + parameterType.getName());
            }

            Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
            for (Type genericParameterType : genericParameterTypes) {
                System.out.println("genericParameterType.getTypeName() = " + genericParameterType.getTypeName());
            }
        }

        Method move = flyCarClass.getMethod("move");
        move.invoke(flyCar);
    }
}
