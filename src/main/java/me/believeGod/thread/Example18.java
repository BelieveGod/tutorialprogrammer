package me.believeGod.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * CountDownLatch 的 示范使用
 * @author LTJ
 * @version 1.0
 * @date 2021/1/5 9:45
 */
public class Example18 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch latch=new CountDownLatch(5);
        List<Runnable> runnableList = new ArrayList<>();
        for(int i=0;i<5;i++){
            runnableList.add(new MyThread18(latch));
        }
        runnableList.forEach(runnable -> executorService.submit(runnable));

        latch.await();
        System.out.println("子线程执行完毕，主线程中止线程池");
        executorService.shutdown();
    }

}

class MyThread18 implements Runnable{
    private CountDownLatch latch ;
    private ThreadLocalRandom random=ThreadLocalRandom.current();

    public MyThread18(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime localDateTime=LocalDateTime.now();
            String format = localDateTime.format(formatter);
            System.out.println(Thread.currentThread().getName() + "---" + format);
            Thread.sleep(random.nextInt(1000,3000));
            System.out.println("latch.getCount() = " + latch.getCount());
            latch.countDown();
            System.out.println("latch 减后" + latch.getCount());
        } catch (InterruptedException e) {
            System.out.println("阻塞被中断");
            Thread.currentThread().interrupt();
        }

    }
}
