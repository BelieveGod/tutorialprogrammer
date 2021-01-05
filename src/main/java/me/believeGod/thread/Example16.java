package me.believeGod.thread;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Join 的使用
 * @author LTJ
 * @version 1.0
 * @date 2021/1/4 16:55
 */
public class Example16 {


    public static void main(String[] args) {
        String[] words=new String[]{"A","B","C","D","E","F"};
        List<Thread> threads = new ArrayList<>();
        Thread pre=null;
        for(int i=0;i<words.length;i++){
            threads.add(new Thread(new JoinAble(words[i],pre)));
            pre=threads.get(i);
        }
        threads.forEach(thread -> thread.start());

    }
}


class JoinAble implements Runnable{
    private String word;
    private Thread pre;
    public JoinAble(String word,Thread pre) {
        this.word = word;
        this.pre=pre;
    }

    @Override
    public void run() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int i = random.nextInt(100,400);
        try {
            if(pre!=null){
                pre.join();
            }
            Thread.sleep(i);
            System.out.println(word);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
