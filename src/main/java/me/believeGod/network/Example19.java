package me.believeGod.network;

import java.net.InetAddress;

/**
 * @ClassName Example19
 * @Description InetAddress常用方法演示
 * @Author Tim
 * @Date 2020/6/8 11:50
 * @Version 1.0
 */
public class Example19 {
    public static void main(String[] args) throws Exception{
        InetAddress localAddress=InetAddress.getLocalHost();
        InetAddress remoteAddress = InetAddress.getByName("www.baidu.com");
        System.out.println("本机的IP地址：" + localAddress.getHostAddress());
        System.out.println("baidu的IP地址：" + remoteAddress.getHostAddress());
        System.out.println("3秒是否可达：" + remoteAddress.isReachable(300));
        System.out.println("baidu的主机名为："+remoteAddress.getHostName());
    }
}
