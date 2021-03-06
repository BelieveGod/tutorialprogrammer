package me.believeGod.thread;

/**
 * @ClassName Example08
 * @Description 同步方法演示
 * @Author Tim
 * @Date 2020/6/7 21:24
 * @Version 1.0
 */
public class Example08 {
    public static void main(String[] args) {
        TicketWindow4 tw = new TicketWindow4();
        new Thread(tw, "窗口1").start();
        new Thread(tw, "窗口2").start();
        new Thread(tw, "窗口3").start();
        new Thread(tw, "窗口4").start();

    }
}

class TicketWindow4 implements Runnable {
    private int tickets = 10;
    // 任意定义一个对象作为锁，也可以用this指针
    private Object lock = new Object();

    public void run() {
        while (true) {
            saleTicket();
            if(tickets<=0){
                break;
            }
        }
    }

    private synchronized void saleTicket() {
        if (tickets > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread th = Thread.currentThread();
            String th_name = th.getName();
            System.out.println(th_name + "正在发售第" + tickets-- + "张票");
        }
    }
}

