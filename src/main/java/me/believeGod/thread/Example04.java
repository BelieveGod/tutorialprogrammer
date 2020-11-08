package me.believeGod.thread;

/**
 * @ClassName Example04
 * @Description 这个例子演示用继承 Thread 的方式，实现多线程。并且是一个错误的示范例子，存在线程安全的问题，对共享变量的写操作没有进行锁。
 * @Author Tim
 * @Date 2020/6/7 20:04
 * @Version 1.0
 */
public class Example04 {
    public static void main(String[] args) {
        new TicketWindow().start();
        new TicketWindow().start();
        new TicketWindow().start();
        new TicketWindow().start();
    }
}

class TicketWindow extends Thread{
    private static int tickets=100;
    public void run(){
        while(true){
            if(tickets>0){
                tickets--;
                try {
                    // 模拟复杂操作
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int num=tickets;
                Thread th=Thread.currentThread();
                String th_name=th.getName();
                System.out.println(th_name+"正在发售第"+num+"张票");
            }
        }
    }
}