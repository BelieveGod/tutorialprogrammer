package me.believeGod.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ClassName Example20
 * @Description TODO
 * @Author Tim
 * @Date 2020/6/8 13:05
 * @Version 1.0
 */
public class Example20 {
    public static void main(String[] args) throws Exception{
        byte[] buf=new byte[1024];
        DatagramSocket ds=new DatagramSocket(8954);
        DatagramPacket dp=new DatagramPacket(buf,1024);
        System.out.println("等待接收数据");
        ds.receive(dp);
        String str = new String(dp.getData(), 0, dp.getLength()) + " from " + dp.getAddress().getHostAddress() + ":" + dp.getPort();
        System.out.println(str);
        ds.close();
    }
}
