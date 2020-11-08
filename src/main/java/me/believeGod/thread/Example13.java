package me.believeGod.thread;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @ClassName Example13
 * @Description 示范了Callable,Future,FutureTask的使用
 * @Author believeGod
 * @Date 2020/9/28 12:14
 * @Version 1.0
 */
public class Example13 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        FutureTask<String> futureTask = new FutureTask<>(new MyTask());
        LocalDateTime begin = LocalDateTime.now();
        executorService.execute(futureTask);
        System.out.println("begin = " + begin);
        System.out.println("futureTask.get() = " + futureTask.get());
        LocalDateTime end=LocalDateTime.now();
        System.out.println("end = " + end);
        Duration duration=Duration.between(begin,end);
        long seconds = duration.getSeconds();
        System.out.println("seconds = " + seconds);
        long l = duration.toMillis();
        System.out.println("l = " + l);
        System.out.println("main is running");
        executorService.shutdown();
    }


    public static class MyTask implements Callable<String> {


        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            return "Hello World";
        }
    }
}

