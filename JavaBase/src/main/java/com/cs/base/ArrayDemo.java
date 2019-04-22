package com.cs.base;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/6 9:33
 * @description： 数组
 * @modified By：
 * @version: $
 * <p>
 * <p>
 * 栈内存 -> 存储局部变量
 * 堆内存 -> 存储new出来的东西
 * 方法区 -> 本地方法区 (和系统相关)、寄存器 (给CPU使用)
 * <p>
 * <p>
 * <p>
 * <p>
 * // 十进制到二进制，八进制，十六进制
 * System.out.println(Integer.toBinaryString(100));
 * System.out.println(Integer.toOctalString(100));
 * System.out.println(Integer.toHexString(100));
 * System.out.println("-------------------------");
 * <p>
 * // 十进制到其他进制
 * System.out.println(Integer.toString(100, 10));
 * System.out.println(Integer.toString(100, 2));
 * System.out.println(Integer.toString(100, 8));
 * System.out.println(Integer.toString(100, 16));
 * System.out.println(Integer.toString(100, 5));
 * System.out.println(Integer.toString(100, 7));
 * System.out.println(Integer.toString(100, -7));
 * System.out.println(Integer.toString(100, 70));
 * System.out.println(Integer.toString(100, 1));
 * System.out.println(Integer.toString(100, 17));
 * System.out.println(Integer.toString(100, 32));
 * System.out.println(Integer.toString(100, 37));
 * System.out.println(Integer.toString(100, 36));
 * System.out.println("-------------------------");
 * <p>
 * //其他进制到十进制
 * System.out.println(Integer.parseInt("100", 10));
 * System.out.println(Integer.parseInt("100", 2));
 * System.out.println(Integer.parseInt("100", 8));
 * System.out.println(Integer.parseInt("100", 16));
 * System.out.println(Integer.parseInt("100", 23));
 */
public class ArrayDemo {


    public static void main(String[] args) {

        int[] intArray = new int[5];  // 动态初始化：初始化时只指定数组长度，由系统为数组分配初始值
        int[] intArray2 = new int[]{1, 2, 3}; //静态初始化：初始化时指定每个数组元素的初始值，由系统决定数组长度
        int[] intArray3 = {4, 5, 6};          //简化写法

        int[][] intArray4 = new int[4][3]; //二维数组
        int[][] intArray5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 13}}; //二维数组
//        yanghuiTriangle();

        arraySort();//数组排序
    }

    private static void arraySort() {
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("--------- 冒泡排序 --------- ");
        System.out.print("排序前: ");
        printArray(arr);


        //冒泡排序
        //相邻元素两两比较，大的往后放，第一次完毕，最大值出现在了最大索引处.同理，即可得到排好序的数组
        //总共的比较次数 ：
        for (int i = 0; i < arr.length - 1; i++) { //第一层循环代表要进行多少轮比较
            for (int j = 0; j < arr.length - 1 - i; j++) { //第二层循环代表每一轮要比较多少次

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.print("第 " + (i + 1) + " 轮排序完 -->");
            printArray(arr);
        }
        System.out.print("排序后: ");
        printArray(arr);


        int[] arr2 = {24, 69, 80, 57, 13};
        System.out.println("--------- 选择排序 --------- ");
        System.out.print("排序前: ");
        printArray(arr2);

        //选择排序
        //第一个元素依次和后面的所有元素进行比较。第一次结束后，就会有最小值出现在最前面。依次类推
        //总共的比较次数 ：
        for (int i = 0; i < arr2.length - 1; i++) { //第一层循环代表要进行多少轮比较
            for (int j = i + 1; j < arr2.length; j++) { //第二层循环代表每一轮要比较多少次

                if (arr2[i] > arr2[j]) {

                    int temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            System.out.print("第 " + (i + 1) + " 轮排序完 -->");
            printArray(arr2);
        }
        System.out.print("排序后: ");
        printArray(arr2);


        //字符串中的字符进行排序。举例：”dacgebf”。结果：”abcdefg”

        String string = "dacgebf";
        System.out.println("字符串排序前: " + string);
        char[] charArray = string.toCharArray(); //把字符串转换为字符数组

        // 把字符数组进行排序
        for (int i = 0; i < charArray.length - 1; i++) {
            for (int j = 0; j < charArray.length - 1 - i; j++) {

                if (charArray[j] > charArray[j + 1]) {
                    char temp = charArray[j];
                    charArray[j] = charArray[j + 1];
                    charArray[j + 1] = temp;
                }
            }
        }
        String resultString = new String(charArray);
        System.out.print("字符串排序后: " + resultString);


        // 定义一个数组
        int[] arr3 = {24, 69, 80, 57, 13};
        // public static String toString(int[] a) 把数组转成字符串
        System.out.println("排序前：" + Arrays.toString(arr3));

        // public static void sort(int[] a) 对数组进行排序
        Arrays.sort(arr);//底层是快速排序，了解就可以了
        System.out.println("排序后：" + Arrays.toString(arr));

        // [13, 24, 57, 69, 80]
        // public static int binarySearch(int[] a,int key) 二分查找
        System.out.println("binarySearch:" + Arrays.binarySearch(arr, 57));
        System.out.println("binarySearch:" + Arrays.binarySearch(arr, 577));

    }

    // 遍历功能
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                System.out.print(arr[x]);
            } else {
                System.out.print(arr[x] + ", ");
            }
        }
        System.out.println("]");
    }


    /**
     * 打印杨辉三角形
     * <p>
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * 1 5 10 10 5 1
     * <p>
     * A:任何一行的第一列和最后一列都是1
     * B:从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
     */
    private static void yanghuiTriangle() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个整数: ");
        int n = scanner.nextInt();

        //定义二维数组
        int[][] aar = new int[n][n];

        //给这个二维数组任何一行的第一列和最后一列赋值为1
        for (int i = 0; i < aar.length; i++) {
            aar[i][0] = 1;
            aar[i][i] = 1;
        }

        //按照规律给其他元素赋值
        //从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
        for (int x = 2; x < aar.length; x++) {
            for (int y = 1; y <= x - 1; y++) {
                aar[x][y] = aar[x - 1][y - 1] + aar[x - 1][y];
            }
        }

        for (int x = 0; x < aar.length; x++) {

            for (int y = 0; y <= x; y++) {
                System.out.print(aar[x][y] + " ");
            }
            System.out.println();
        }
    }
}
