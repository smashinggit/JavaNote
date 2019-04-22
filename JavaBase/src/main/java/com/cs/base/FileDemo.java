package com.cs.base;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/11 16:25
 * @description：3
 * @modified By：
 * @version: $
 */
public class FileDemo {

    public static void main(String[] args) {

        // File(String pathname)：根据一个路径得到File对象
        File file = new File("E:\\fileTest\\test.txt");

        // File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
        File file2 = new File("E:\\fileTest", "test.txt");

        // File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
        File file3 = new File("E:\\fileTest");
        File file4 = new File(file3, "test.txt");

//        public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
//        public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
//        public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
//
//        要想在某个目录下创建内容，该目录首先必须存在。
//        要创建文件还是文件夹，要弄清楚，方法不要调错了
        try {
            System.out.println("file3.createNewFile " + file3.mkdirs());
            System.out.println("file.createNewFile " + file.createNewFile());
        } catch (Exception e) {
            e.printStackTrace();
        }


//        如果路径名相同，就是改名。
//        如果路径名不同，就是改名并剪切。
//        路径以盘符开始：绝对路径 c:\a.txt
//        路径不以盘符开始：相对路径 a.txt
        try {
            // 创建一个文件对象
            File file5 = new File(file3, "1.jpg");
            file5.createNewFile();
            // 需求：我要修改这个文件的名称为"2.jpg"
            File file6 = new File(file3, "2.jpg");
            System.out.println("renameTo:" + file5.renameTo(file6));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("file.getAbsolutePath:" + file.getAbsolutePath()); //获取绝对路径
        System.out.println("file.getPath:" + file.getPath()); //获取相对路径
        System.out.println("file.length:" + file.length()); //获取长度。字节数.
        System.out.println("file.lastModified:" + file.lastModified()); //获取最后一次的修改时间，毫秒值

        fileTest();

    }


    private static void fileTest() {
        File fileE = new File("E:\\");
        File testJpg = new File(fileE, "test.jpg");

        //判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出此文件名称
        try {
            testJpg.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取该目录下所有文件或者文件夹的File数组
        File[] fileArray = fileE.listFiles();

        for (File file : fileArray) {

            if (file.isFile()) {

                if (file.getName().endsWith(".jpg")) {
                    System.out.println(file.getName());
                }
            }
        }


        //文件名称过滤器
        // 获取该目录下所有文件或者文件夹的String数组
        String[] strings = fileE.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //如果是文件，输出以.jpg结尾的文件，这两个条件要同时满足
                return new File(dir, name).isFile() && name.endsWith(".jpg");
            }
        });

        // 遍历
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
