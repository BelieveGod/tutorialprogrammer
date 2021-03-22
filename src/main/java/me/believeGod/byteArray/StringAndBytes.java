package me.believeGod.byteArray;

import org.junit.Test;

import java.util.Arrays;

/**
 * 探索 Java 中，字符和Byte的关系
 */
public class StringAndBytes {

    @Test
    public void test(){
        String a="a";
        byte[] bytes = a.getBytes();
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test2(){
        String a="2";
        byte[] bytes = a.getBytes();
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test3(){
        // UTF-8 [-28, -72, -83]
        // unicode-16  [78,45]
        String a="中";
        byte[] bytes = a.getBytes();

        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test4(){
        byte[] bytes = {-28, -72, -83};
        String s = new String(bytes);
        System.out.println("s = " + s);
        byte[] bytes1 = s.getBytes();
        System.out.println("Arrays.toString(bytes1) = " + Arrays.toString(bytes1));
    }

    @Test
    public void test5(){
        byte[] bytes = {(byte)0b10101001};
        String s=new String(bytes);
        System.out.println("s = " + s);
        byte[] bytes1 = s.getBytes();
        System.out.println("Arrays.toString(bytes1) = " + Arrays.toString(bytes1));
    }
}
