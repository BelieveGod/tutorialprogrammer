package me.believeGod.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName Example20_1
 * @Description TODO
 * @Author Tim
 * @Date 2020/6/8 13:12
 * @Version 1.0
 */
public class Example20_1 {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket(3000);
        String str="hello world";

        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 8954);
        System.out.println("发送消息：");
        ds.send(dp);
        ds.close();
    }
}
