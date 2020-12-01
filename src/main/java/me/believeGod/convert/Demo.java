package me.believeGod.convert;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 测试字符串科学技术法转换成整形
 */
public class Demo {


    public static void main(String[] args) {

        String oringin="12679869";
        String str="1.4e3";
        String str2="126.78869e4";

//        int i = Integer.parseInt(str);
//        System.out.println("i = " + i);


        BigDecimal bigDecimal = new BigDecimal(str2);
        int i1 = bigDecimal.intValue();
        System.out.println("i1 = " + i1);

//        long l = Long.parseLong(str);
//        System.out.println("l = " + l);

        double v = Double.parseDouble(str2);
        System.out.println("v = " + v);

        BigDecimal bd = new BigDecimal("300008.56182503598E8");
        System.out.println(bd.toPlainString());

    }


    /**
     * 测试浮点数的计算精度
     */
    @Test
    public void test2(){
        Double d=11356.786656;

        int i = d.intValue();
        System.out.println("i = " + i);

        long l = d.longValue();
        System.out.println("l = " + l);

        double v = d.doubleValue();
        System.out.println("v = " + v);

        double floor = Math.floor(d);

        System.out.println("floor = " + floor);

        long round = Math.round(d);

        System.out.println("round = " + round);

        double ceil = Math.ceil(d);
        System.out.println("ceil = " + ceil);

        double v1 = d - i;
        System.out.println("v1 = " + v1);

        double v2 = v1 * 100;
        System.out.println("v2 = " + v2);

        Double l1 = Math.round(v1 * 100 / 60.0 * 10000) / 10000.0;
        System.out.println("l1 = " + l1);

        double v3 = l1 + i;
        System.out.println("v3 = " + v3);

    }

}
