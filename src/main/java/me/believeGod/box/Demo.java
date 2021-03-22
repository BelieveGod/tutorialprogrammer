package me.believeGod.box;

import org.junit.Test;

/**
 * 关于包装类和原始类的测试例子
 */
public class Demo {

    /**
     * 经典的Integer == 号比较大小
     */
    @Test
    public void test(){
        Integer a=127;
        Integer b=127;
        System.out.println("Integer 127 == Integer 127 ?"+ (a==b));

        Integer c=128;
        Integer d=128;
        System.out.println("Integer 128 == Integer 128 ?"+ (c==d));
    }

    /**
     * Integer与Integer 的 equal 比较
     */
    @Test
    public void test2(){
        Integer a=127;
        Integer b=127;
        System.out.println("Integer 127 eq Integer 127 ?"+ (a.equals(b)));

        Integer c=128;
        Integer d=128;
        System.out.println("Integer 128 eq Integer 128 ?"+ (c.equals(d)));
    }

    /**
     * Integer 和 int 比较
     */
    @Test
    public void test3(){
        Integer a=127;
        int b=127;
        System.out.println("Integer 127 == int 127 ?"+ (a==b));
        System.out.println("Integer 127 eq int 127 ?"+ (a.equals(b)));

        Integer c=128;
        int d=128;

        System.out.println("Integer 128 == int 128 ?"+ (c==d));
        System.out.println("Integer 128 eq int 128 ?"+ (c.equals(d)));
    }

    /**
     * Integer 赋值看是否变化；
     */
    @Test
    public void test4(){
        Integer a=127;
        Integer b=a;
        String s = String.format("a=127,b=a;  output:a=%d , b=%d", a, b);
        System.out.println(s);

        a=256;
        s = String.format("change a=256;  output:a=%d, b=%d", a, b);
        System.out.println(s);
    }
}
