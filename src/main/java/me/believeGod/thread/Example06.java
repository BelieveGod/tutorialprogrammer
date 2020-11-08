package me.believeGod.thread;

/**
 * @ClassName Example06
 * @Description 这个例子展示一个后台线程创建方式。
 * @Author Tim
 * @Date 2020/6/7 20:43
 * @Version 1.0
 */
public class Example06 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main线程是后台线程吗？"+Thread.currentThread().isDaemon());
        DamonThread dt=new DamonThread();
        Thread t = new Thread(dt, "后台线程");
        System.out.println("t线程是后台线程吗？" + t.isDaemon());
        t.setDaemon(true);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        Thread.sleep(100);
    }
}

class DamonThread implements Runnable{
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "---is running.");
        }
    }
}
