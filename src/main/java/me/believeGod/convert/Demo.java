package me.believeGod.convert;

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

}
