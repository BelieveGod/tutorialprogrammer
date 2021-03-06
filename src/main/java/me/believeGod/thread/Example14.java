package me.believeGod.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Example14
 * @Description 示范使用AtomicInteger
 * @Author believeGod
 * @Date 2020/9/29 13:13
 * @Version 1.0
 */
public class Example14 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        AtomicInteger atomicInteger=new AtomicInteger(5);
        List<Runnable> runnableList = new ArrayList<>();
        for(int i=0;i<5;i++){
            runnableList.add(new MyThread14(atomicInteger));
        }
        runnableList.forEach(runnable -> executorService.submit(runnable));

        while (atomicInteger.get()>0){
            Thread.sleep(100);
        }
        System.out.println("子线程执行完毕，主线程中止线程池");
        executorService.shutdown();
    }

}

class MyThread14 implements Runnable{
    private AtomicInteger atomicInteger ;
    private ThreadLocalRandom random=ThreadLocalRandom.current();

    public MyThread14(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        try {
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime localDateTime=LocalDateTime.now();
            String format = localDateTime.format(formatter);
            System.out.println(Thread.currentThread().getName() + "---" + format);
            Thread.sleep(random.nextInt(1000,3000));
            System.out.println("atomicInteger.addAndGet(-1) = " + atomicInteger.addAndGet(-1));
        } catch (InterruptedException e) {
            System.out.println("阻塞被中断");
            Thread.currentThread().interrupt();
        }

    }
}
