package me.believeGod.time;

import java.time.*;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("日期："+now);

        LocalTime now1 = LocalTime.now();
        System.out.println("时间:"+now1);

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("日期时间："+now2);


        System.out.println("年："+now2.getYear());
        System.out.println("月："+now2.getMonth());
        System.out.println("日："+now2.getDayOfMonth());
        System.out.println("星期几："+now2.getDayOfWeek());
        System.out.println("一年的第几天："+now2.getDayOfYear());


        System.out.println("这个月有几天："+now.lengthOfMonth());
        System.out.println("一年有几天："+now.lengthOfYear());
        System.out.println("是否闰年："+now.isLeapYear());


        Instant instant=Instant.now();
        System.out.println("instant:"+instant);

        LocalDateTime localDateTime = LocalDate.of(2019, 8, 8).atStartOfDay();
        System.out.println(localDateTime);

        Duration between = Duration.between(localDateTime, now2);
        System.out.println(between.toDays());
        System.out.println(between.toHours());

        Period between1 = Period.between(localDateTime.toLocalDate(), now);
        System.out.println(between1.getYears());
        System.out.println(between1.getMonths());
        System.out.println(between1.getDays());

    }
}
