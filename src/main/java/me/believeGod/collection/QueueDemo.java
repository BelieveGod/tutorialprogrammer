package me.believeGod.collection;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueDemo {

    @Test
    public void test() throws InterruptedException {
        final BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(2);
        new Thread(new Runnable() {
            public void run() {
                try {
//                    todo 为什么循环不管用
                    for(int i=0;i<4;i++){
                        System.out.println(queue.take());
                        System.out.println("i = " + i);
                        Thread.sleep(100);
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Instant start=Instant.now();
        queue.put("11");
        queue.put("22");
        queue.put("33");
        queue.put("44");
        Instant end=Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("duration.toMillis() = " + duration.toMillis());
    }

    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(2);
        new Thread(new Runnable() {
            public void run() {
                try {
//                    todo 为什么循环不管用
                    for(int i=0;i<4;i++){
                        System.out.println(queue.take());
                        System.out.println("i = " + i);
                        Thread.sleep(100);
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Instant start=Instant.now();
        queue.put("11");
        queue.put("22");
        queue.put("33");
        queue.put("44");
        Instant end=Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("duration.toMillis() = " + duration.toMillis());
    }
}
