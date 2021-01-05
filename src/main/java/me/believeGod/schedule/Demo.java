package me.believeGod.schedule;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * 控制线程暂停 和 恢复 的demo
 * @author LTJ
 * @version 1.0
 * @date 2021/1/4 9:30
 */
public class Demo {

    @Test
    public void test() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
         class Say implements Runnable{
            public  volatile int status=1;
            @Override
            public void run() {

                    if(status==1){
                        System.out.println("hello world");
                    }
                    else{
                        try {
                            synchronized (this){

                                wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

            }

            public  synchronized void resume(){
                status=1;
                notify();
            }

            public  void stop(){
                status=-1;
            }
        }
        Say say= new Say();

        executorService.scheduleAtFixedRate(say, 0, 2, TimeUnit.SECONDS);
        Thread.sleep(2000);
        System.out.println("准备执行定时任务");
        Thread.sleep(5000);
        System.out.println("准备关闭定时任务");
        say.stop();
        Thread.sleep(5000);
        System.out.println("恢复任务");
        say.resume();
//        executorService.shutdown();
        while(true);
    }


}
