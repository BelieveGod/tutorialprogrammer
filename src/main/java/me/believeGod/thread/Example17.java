package me.believeGod.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * SeamPhore 的 示范使用
 * @author LTJ
 * @version 1.0
 * @date 2021/1/5 9:45
 */
public class Example17 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Semaphore semaphore=new Semaphore(3);
        List<Runnable> runnableList = new ArrayList<>();
        for(int i=0;i<10;i++){
            runnableList.add(new MyThread17(semaphore));
        }
        runnableList.forEach(runnable -> executorService.submit(runnable));

        // shutdown 是不再加入新任务，执行完已有的任务
        executorService.shutdown();
        // shutdownNow 是不在加入新任务，向所有线程执行中断，
//        executorService.shutdownNow();
    }

}

class MyThread17 implements Runnable{
    private Semaphore semaphore ;
    private ThreadLocalRandom random=ThreadLocalRandom.current();

    public MyThread17(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(2000,6000));
            semaphore.acquire();
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime localDateTime=LocalDateTime.now();
            String format = localDateTime.format(formatter);
            System.out.println(Thread.currentThread().getName() + "---" + format);
            int i = 3-semaphore.availablePermits();
            System.out.println("当前并发数：" + i);

            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println("阻塞被中断");
            Thread.currentThread().interrupt();
        }

    }
}
