package me.believeGod.thread;

/**
 * @ClassName TestThread
 * @Description TODO
 * @Author Tim
 * @Date 2020/6/7 18:07
 * @Version 1.0
 */
public class Example11 {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread=new MyThread2();

        MyThread3 myThread3=new MyThread3();
        Thread thread = new Thread(myThread3);

        myThread.start();
        thread.start();
        do {
            System.out.println("Main方法在运行");
            Thread.sleep(2000);

        } while (true);

    }
}

class MyThread{
    public void run() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println("MyThread类的run()方法在运行");

        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run()  {
        while(true){

            System.out.println("MyThread2类的run()方法在运行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class MyThread3 implements Runnable{

    public void run() {
        while(true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread3类的run()方法在运行");

        }
    }
}
