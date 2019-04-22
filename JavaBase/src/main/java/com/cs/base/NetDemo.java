package com.cs.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/14 11:52
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * <p>
 * TCP
 * 建立连接，形成传输数据的通道
 * 在连接中进行大数据量传输
 * 通过三次握手完成连接，是可靠协议
 * 必须建立连接，效率会稍低
 * UDP
 * 将数据源和目的封装成数据包中，不需要建立连接
 * 每个数据包的大小在限制在64k
 * 因无连接，是不可靠协议
 * 不需要建立连接，速度快
 * 一般的软件它既有UDP，又有TCP，用TCP来保证软件的可靠性，用UDP来保证软件的传输速度快。
 * <p>
 * Socket套接字：
 * 网络上具有唯一标识的IP地址和端口号组合在一起才能构成唯一能识别的标识符套接字。
 * Socket原理机制：
 * 通信的两端都有Socket。
 * 网络通信其实就是Socket间的通信。
 * 数据在两个Socket间通过IO传输。
 */
public class NetDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("本机Ip " + InetAddress.getLocalHost().getHostAddress());
//        UdpSendDemo.main(args);
//        UDPReceiveDemo.main(args);

        DatagramSocket dsSend = new DatagramSocket();
        DatagramSocket dsReceive = new DatagramSocket(12345);

        SendThread sendThread = new SendThread(dsSend);
        ReceiveThread receiveThread = new ReceiveThread(dsReceive);

        Thread thread1 = new Thread(sendThread);
        Thread thread2 = new Thread(receiveThread);

        thread1.start();
        thread2.start();

    }

}

class ReceiveThread implements Runnable {


    private DatagramSocket socket;

    public ReceiveThread(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            while (true) {
                // 创建一个包裹
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

                // 接收数据
                socket.receive(datagramPacket); //阻塞

                // 解析数据
                String ip = datagramPacket.getAddress().getHostAddress();
                String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("from " + ip + " data is : " + s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }

    }
}


class SendThread implements Runnable {

    DatagramSocket socket;

    public SendThread(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            // 封装键盘录入数据
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null) {
                if ("886".equals(line)) {
                    break;
                }

                byte[] bytes = line.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,
                        InetAddress.getLocalHost(), 12346);

                // 发送数据
                socket.send(datagramPacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }

    }
}


/**
 * 我们要用UDP传输数据时，怎么用Socket建立连接呢？
 * <p>
 * DatagramSocket与DatagramPacket
 * 建立发送端，接收端。
 * 建立数据包。
 * 调用Socket的发送接收方法。
 * 关闭Socket。
 * <p>
 * Datagram(数据报)
 * <p>
 * <p>
 * 需求：接收指定端口发送过来的数据
 * *
 * * UDP协议发送数据：
 * * A:创建发送端Socket对象
 * * B:创建数据，并把数据打包
 * * C:调用Socket对象的发送方法发送数据包
 * * D:释放资源
 */
class UdpSendDemo {

    public static void main(String[] args) throws Exception {


        // 创建发送端Socket对象
        DatagramSocket datagramSocket = new DatagramSocket();

        // 创建数据，并把数据打包
        // DatagramPacket(byte[] buf, int length, InetAddress address, int port)
        // 创建数据
        byte[] bytes = "UDP过来了".getBytes();
        InetAddress address = InetAddress.getLocalHost();
        int port = 12345;
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, port);

        // 调用Socket对象的发送方法发送数据包
        // public void send(DatagramPacket p)
        datagramSocket.send(datagramPacket);

        // 释放资源
        datagramSocket.close();
    }
}

/**
 * * UDP协议接收数据：
 * * A:创建接收端Socket对象
 * * B:创建一个数据包(接收容器)
 * * C:调用Socket对象的接收方法接收数据
 * * D:解析数据包，并显示在控制台
 * * E:释放资源
 */
class UDPReceiveDemo {

    public static void main(String[] args) throws Exception {

        int port = 12345;
        DatagramSocket datagramSocket = new DatagramSocket(port, InetAddress.getLocalHost());

        // 创建一个数据包(接收容器)
        // DatagramPacket(byte[] buf, int length)
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);


        // 调用Socket对象的接收方法接收数据
        // public void receive(DatagramPacket p)
        datagramSocket.receive(datagramPacket); // 阻塞式

        // 解析数据包，并显示在控制台
        // 获取对方的ip
        InetAddress address = datagramPacket.getAddress();
        String ip = address.getHostAddress();
        int sendPort = datagramPacket.getPort();

        // public byte[] getData():获取数据缓冲区
        // public int getLength():获取数据的实际长度
        byte[] data = datagramPacket.getData();
        String result = new String(data, 0, data.length);

        System.out.println(ip + ":" + sendPort + "传递的数据是:" + result);
        datagramSocket.close();
    }

}
