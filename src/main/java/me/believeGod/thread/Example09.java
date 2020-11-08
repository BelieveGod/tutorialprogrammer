package me.believeGod.thread;

/**
 * @ClassName Example09
 * @Description 多线程通信问题的引入,错误示例
 * @Author Tim
 * @Date 2020/6/7 21:43
 * @Version 1.0
 */
public class Example09 {
    public static void main(String[] args) {
        Storage st=new Storage();
        Input input=new Input(st);
        Output output = new Output(st);
        new Thread(input).start();
        new Thread(output).start();
    }

}

class Storage{
    // 数据存储数组
    private int[] cells = new int[10];
    // inPos 表示存入时数组下标，outPos 表示取出时数组下标
    private int inPos,outPos;
    // 定义一个 put 方法向数组中存入数据
    public void put(int num){
        cells[inPos]=num;
        System.out.println("在cells[" + inPos + "]中放入数据---" + cells[inPos]);
        inPos++;
        if(inPos==cells.length){
            inPos=0;
        }
    }

    // 定义一个 get() 方法从数组中取出数据
    public void get(){
        int data=cells[outPos];
        System.out.println("从 cells[" + outPos + "] 中取出数据" + data);
        outPos++;
        if(outPos==cells.length){
            outPos=0;
        }
    }
}

class Input implements Runnable{
    private Storage st;
    private int num;

    public Input(Storage st) {
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

class Output implements Runnable{
    private Storage st;


    public Output(Storage st) {
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
