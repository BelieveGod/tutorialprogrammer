package me.believeGod.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Example21
 * @Description TODO
 * @Author Tim
 * @Date 2020/6/8 17:01
 * @Version 1.0
 */
public class Example21 {
    public static void main(String[] args) throws IOException {
        new TCPServer().listen();
    }
}

class TCPServer{
    private final int DEFAULT_PORT=7788;

    public void listen() throws IOException {
        ServerSocket serverSocket=new ServerSocket(DEFAULT_PORT);
        while(true){
            Socket client = serverSocket.accept();
            new Thread(new Action(client)).start();
        }
    }

    private static class Action implements Runnable{
        private Socket client;

        public Action(Socket client) {
            this.client = client;
        }

        public void run() {
            try( OutputStream  os = client.getOutputStream()) {
                System.out.println("正在与客户端交流");
                os.write("鸿诚服务欢迎您！".getBytes());
                Thread.sleep(5000);
                System.out.println("结束与客户端交流");
                client.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}


