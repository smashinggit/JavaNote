package com.cs.base;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/15 9:43
 * @description：
 * @modified By：
 * @version: $
 */
public class NetDemo2 {

    /* TCP协议发送数据：
     * A:创建发送端的Socket对象
     *      这一步如果成功，就说明连接已经建立成功了。
     * B:获取输出流，写数据
     * C:释放资源
     */
    public static void main(String[] args) throws Exception {
        // 创建发送端的Socket对象
        Socket socket = new Socket("192.168.243.2", 8899);
        // 获取输出流，写数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("TCP来了".getBytes());
        socket.close();

        Client.main(args);
    }
}


/*
 * TCP协议接收数据：
 * A:创建接收端的Socket对象
 * B:监听客户端连接。返回一个对应的Socket对象
 * C:获取输入流，读取数据显示在控制台
 * D:释放资源
 */
class Client {

    public static void main(String[] args) throws Exception {

        // 创建接收端的Socket对象
        ServerSocket serverSocket = new ServerSocket(8899);

        // 监听客户端连接。返回一个对应的Socket对象
        Socket receivedSocket = serverSocket.accept(); // 侦听并接受到此套接字的连接。此方法在连接传入之前一直阻塞。

        // 获取输入流，读取数据显示在控制台
        InputStream inputStream = receivedSocket.getInputStream();

        byte[] bytes = new byte[1024];
        int length = inputStream.read(bytes);// 阻塞式方法

        String result = new String(bytes, 0, length);

        System.out.println(receivedSocket.getInetAddress().getHostAddress() + "---" + result);

        serverSocket.close();
    }


}