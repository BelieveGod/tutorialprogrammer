package me.believeGod.collection;

import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.*;

/**
 * list 集合的 clear方法，sublist 方法，addAll方法
 * list添加一个视图，是否会影响原本的对象
 */
public class Demo {

    @Test
    public void test1(){
        List<Map> list = new ArrayList();

        Map map = new HashMap();
        map.put("1",1);


        list.add(map);
        Map map1 = list.get(0);

        System.out.println("map.get(\"1\") = " + map.get("1"));
        map1.put("1",2);
        System.out.println("map.get(\"1\") = " + map.get("1"));
        System.out.println("map1.get(\"1\") = " + map1.get("1"));

    }

    /**
     * 看addAll 是否源影响原来的对象;其实是会影响原始数据的，不过包装类的= 号被编译器处理过，原始数据的大小是不能被该的；
     * 变量的存储，实际上是内存上一个地址。当用 a=b，修改时，对象改变得到是地址，而不是地址上的内容。除了原始数据
     */
    @Test
    public void test2(){
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new ArrayList();

        list.addAll(Arrays.asList(arr));


        Arrays.asList(arr).stream().forEach(System.out::print);
        System.out.println();
        list.stream().forEach(System.out::print);
        arr[3]=0;
        System.out.println();
        Arrays.asList(arr).stream().forEach(System.out::print);
        System.out.println();
        list.stream().forEach(System.out::print);


    }

    @Test
    public void test3(){
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new ArrayList();
        list.addAll(Arrays.asList(arr));

        List<Integer> integers = list.subList(0, 3);
        integers.stream().forEach(System.out::print);

        System.out.println();

        int i = list.indexOf(4);
        System.out.println("i = " + i);


        int subListSize = integers.size();
        System.out.println("subListSize = " + subListSize);
//        视图的操作都会反映到原表上
        list.subList(1,2).clear();
//        对原列表操作后，不能再操作视图列表，否则会发生异常
//        int subListSize2 = integers.size();


        list.stream().forEach(System.out::print);

    }

    @Test
    public void test4(){
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new ArrayList();
        list.addAll(Arrays.asList(arr));

        while(list.size()>0){
            System.out.println("size:"+list.size());
            list.subList(0,1).clear();
        }
        System.out.println("size:"+list.size());
    }

    @Test
    public void test5(){
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new ArrayList();
        List<Integer> list2 = new ArrayList();
        list.addAll(Arrays.asList(arr));

        list2.addAll(list.subList(0, 3));
        list2.forEach(System.out::println);
        list.subList(0,3).clear();
        list2.forEach(System.out::println);
        System.out.println("==============");
        list.forEach(System.out::println);

        System.out.println("integers.size() = " + list.size());
        System.out.println("integers.size() = " + list2.size());
    }

    @Test
    public void test6(){
        String[] arr = new String[]{"1", "1","1", "1", "1", "1", "1", "1"};
        List<String> list = new ArrayList();
        list.addAll(Arrays.asList(arr));

        String[] strings = list.toArray(new String[0]);
        for (String string : strings) {
            System.out.println(string);
        }
        list.clear();
        System.out.println();
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(list.size());

    }
}
