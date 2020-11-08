package me.believeGod.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Example12
 * @Description 使用线程池创建线程。
 * @Author believeGod
 * @Date 2020/9/26 9:58
 * @Version 1.0
 */
public class Example12 {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        MyThread myThread=new MyThread();

// 注意submit 和 excute 的区别
        fixedThreadPool.submit(myThread);
//        fixedThreadPool.execute(myThread);
        for(int i=0;i<10;i++){

            System.out.println("main is running");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fixedThreadPool.shutdown();
        System.out.println(Integer.MAX_VALUE);
    }


    public static class MyThread implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;i++){

                System.out.println("myThread is running");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


