package com.cs.base;

import java.io.*;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/11 17:10
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * O流概述
 * IO流用来处理设备之间的数据传输
 * 上传文件和下载文件
 * Java对数据的操作是通过流的方式
 * Java用于操作流的对象都在IO包中
 * <p>
 * <p>
 * IO流分类
 * 按照数据流向
 * 输入流 读取数据
 * 输出流 写出数据
 * 按照数据类型
 * 字节流
 * 字节输入流 读取数据 InputStream
 * 字节输出流 写出数据 OutputStream
 * 字符流
 * 字符输入流 读取数据 Reader
 * 字符输出流 写出数据 Writer
 */
public class StreamDemo {
    public static void main(String[] args) {

        System.out.println("5的阶乘 " + jieCheng(5));


//        writeAndRead();
//        writeAndRead2();

        //  注意：我们除了用windows记事本能读懂的数据用字符流以外，其余的全部使用字节流。
        CopyFileDemo();
        CopyImageDemo();
    }

    //使用字节流复制数据
    //将a.jpg复制一份，并命名为b.jpg
    private static void CopyImageDemo() {

        File srcFile = new File("a.jpg");
        File desFile = new File("b.jpg");

        try {
            BufferedInputStream bi = new BufferedInputStream(new FileInputStream(srcFile));
            BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(desFile));

            //字节缓冲流一次读写一个字节数组
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = bi.read(bytes)) != -1) {
                bo.write(bytes, 0, length);
            }
            bi.close();
            bo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //使用字符流复制数据
    //将a.txt复制一份，并命名为b.txt
    private static void CopyFileDemo() {
        File srcFile = new File("a.txt");
        File desFile = new File("b.txt");

        //字符缓冲流一次读写一个字符串(推荐)
        try {
            BufferedReader br = new BufferedReader(new FileReader(srcFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(desFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();

                System.out.println("BufferedReader 读取内容 " + line);
                System.out.println("BufferedWriter 写入内容 " + line);
            }
            //字符缓冲流一次读写一个字符数组
//            char[] chars = new char[1024];
//            int length = 0;
//            while ((length = br.read(chars)) != -1) {
//                bw.write(chars, 0, length);
//
//                System.out.println("BufferedReader 读取内容 \n" + new String(chars, 0, length));
//                System.out.println("BufferedWriter 写入内容 \n" + new String(chars, 0, length));
//            }

            br.close();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * 做递归要写一个方法:
     *      返回值类型：int
     *      参数列表：int n
     * 出口条件:
     *      if(n == 1) {return 1;}
     * 规律:
     *      if(n != 1) {return n*方法名(n-1);}
     */
    public static int jieCheng(int n) {
        if (n == 1)
            return 1;
        else
            return n * jieCheng(n - 1);
    }
}
