package me.believeGod.thread;

/**
 * @ClassName Example05
 * @Description 这个例子展示了实现 Runnable 接口的方式实现多线程。并且对共享变量的写操作也没有进行锁操作。
 * @Author Tim
 * @Date 2020/6/7 20:30
 * @Version 1.0
 */
public class Example05 {
    public static void main(String[] args) {
        TicketWindow2 tw=new TicketWindow2();
        new Thread(tw,"窗口1").start();
        new Thread(tw,"窗口2").start();
        new Thread(tw,"窗口3").start();
        new Thread(tw,"窗口4").start();

    }
}

class TicketWindow2 implements Runnable{
    private int tickets=100;

    public void run() {
        while(true){
            if(tickets>0){
                Thread th=Thread.currentThread();
                String th_name=th.getName();
                System.out.println(th_name+"正在发售第"+tickets--+"张票");
            }
        }
    }
}