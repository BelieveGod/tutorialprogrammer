package me.believeGod.reflect;

/**
 * @author LTJ
 * @version 1.0
 * @date 2021/4/28 10:23
 */
public class Vehicle {

    private String engineName = "阿尔法";
    public String Color = "black";

    public void move(){
        System.out.println("vehicle move...");

    }

    private void buildEngine(){
        System.out.printf("建立引擎：%s", engineName);
    }
}
