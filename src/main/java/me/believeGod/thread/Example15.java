package me.believeGod.thread;

/**
 * 示范使用thread.interupt 中断线程
 * 注意 在阻塞中被中断时候要重新设置中断
 * @author LTJ
 * @version 1.0
 * @date 2021/1/4 16:26
 */
public class Example15 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Interuptale(), "可中断线程");
        thread.start();
        Thread.sleep(300);
        System.out.println("中断线程");
        thread.interrupt();
        thread.join();
        System.out.println("主线程结束");


    }
}
 class Interuptale implements Runnable{


    @Override
    public void run() {
       for(int i=0;!Thread.currentThread().isInterrupted()&&i<100;i++){
           System.out.println("i = " + i);
           try {
               Thread.sleep(3000*20);
           } catch (InterruptedException e) {
               e.printStackTrace();
               Thread.currentThread().interrupt();
           }
       }
    }
}
