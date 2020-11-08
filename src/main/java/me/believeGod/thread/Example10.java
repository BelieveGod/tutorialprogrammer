package me.believeGod.thread;

/**
 * @ClassName Example10
 * @Description 多线程通信，正确示例
 * @Author Tim
 * @Date 2020/6/7 22:18
 * @Version 1.0
 */
public class Example10 {
    public static void main(String[] args) {
        Storage01 st01=new Storage01();
        Input01 input01=new Input01(st01);
        Output01 output01 = new Output01(st01);
        new Thread(input01).start();
        new Thread(output01).start();
    }

}

class Storage01{
    // 数据存储数组
    private int[] cells = new int[10];
    // inPos 表示存入时数组下标，outPos 表示取出时数组下标
    private int inPos,outPos;

    private int count=0;

    // 定义一个 put 方法向数组中存入数据
    public synchronized void put(int num){
        while(count==cells.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cells[inPos]=num;
        System.out.println("在cells[" + inPos + "]中放入数据---" + cells[inPos]);
        inPos++;
        if(inPos==cells.length){
            inPos=0;
        }
        count++;
        this.notify();
    }

    // 定义一个 get() 方法从数组中取出数据
    public synchronized void get(){
        while(count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int data=cells[outPos];
        System.out.println("从 cells[" + outPos + "] 中取出数据" + data);
        outPos++;
        if(outPos==cells.length){
            outPos=0;
        }
        count--;
        this.notify();
    }
}

class Input01 implements Runnable{
    private Storage01 st;
    private int num;

    public Input01(Storage01 st) {
        this.st = st;
    }

    public void run() {
        while(true){

            st.put(num++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Output01 implements Runnable{
    private Storage01 st;


    public Output01(Storage01 st) {
        this.st = st;
    }

    public void run() {
        while(true){

            st.get();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
