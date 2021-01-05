package me.believeGod.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  CycleBarrire 使用示例
 * @author LTJ
 * @version 1.0
 * @date 2021/1/5 11:19
 */
public class CycleBarrierTest2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 将线程A添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程A：" + Thread.currentThread().getName() + "执行第1步。");
                    cyclicBarrier.await();
                    System.out.println("线程A：" + Thread.currentThread().getName() + "执行第2步。");
                    cyclicBarrier.await();
                    System.out.println("线程A：" + Thread.currentThread().getName() + "执行第3步。");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // 将线程B添加到线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程B：" + Thread.currentThread().getName() + "执行第1步。");
                    cyclicBarrier.await();
                    System.out.println("线程B：" + Thread.currentThread().getName() + "执行第2步。");
                    cyclicBarrier.await();
                    System.out.println("线程B：" + Thread.currentThread().getName() + "执行第3步。");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // 关闭线程池
        executorService.shutdown();
    }
}
