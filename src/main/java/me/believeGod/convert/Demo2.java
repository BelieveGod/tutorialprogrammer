package me.believeGod.convert;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/11/25 17:17
 */
public class Demo2 {

    public static void main(String[] args) {
        byte b= 0x0A;

        String string = Integer.toHexString(0xFF & b);
        System.out.println("string = " + string);
    }
}
