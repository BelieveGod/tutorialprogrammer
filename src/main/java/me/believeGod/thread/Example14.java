package me.believeGod.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Example14
 * @Description TODO
 * @Author believeGod
 * @Date 2020/9/29 13:13
 * @Version 1.0
 */
public class Example14 implements Runnable{

    private AtomicInteger counter=new AtomicInteger();



    public static void main(String[] args) {
        Example14 example14=new Example14();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            executorService.execute(example14);
        }
        System.out.println(Thread.currentThread().getName());

//        executorService.shutdownNow();
        executorService.shutdown();
    }

    @Override
    public void run() {
        while(true){
            int count = counter.getAndIncrement();
            System.out.println(Thread.currentThread().getName()+":count = " + count);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
