package me.believeGod.network;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName Example21_1
 * @Description TODO
 * @Author Tim
 * @Date 2020/6/8 17:26
 * @Version 1.0
 */
public class Example21_1 {
    public static void main(String[] args) throws Exception {
        new TCPClient().connect();
    }
}

class TCPClient{
    private final int PORT=7788;
    public void connect() throws Exception{
        Socket client=new Socket(InetAddress.getLocalHost(),PORT);
        InputStream is=client.getInputStream();
        byte[] buf=new byte[1024];
        int len=is.read(buf);
        System.out.println(new String(buf, 0, len));
        Thread.sleep(5000);
        is.close();
        client.close();
    }
}