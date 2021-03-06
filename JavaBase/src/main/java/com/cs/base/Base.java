package com.cs.base;


/**
 * bit就是位，也叫比特位，是计算机表示数据最小的单位
 * byte就是字节，1byte=8bit，1byte就是1B
 * 一个字符=2字节；
 * 1KB=1024B
 * <p>
 * <p>
 *            占用字节数         范围
 * byte           1           -128~127
 * short          2         -32768~32767
 * int            4         -2的31次方~2的31次方-1
 * long           8         -2的63次方~2的63次方-1
 * float          4         -3.403E38~3.403E38
 * double         8         -1.798E308~1.798E308
 * char           2
 * boolean        1
 * <p>
 * -------------逻辑运算符-----------------
 * <p>
 * 运算符      运算           示例             结果
 * &       AND(与)       false & true      false
 * |       OR(或)        false | true      true
 * ^       XOR(异或)     false | true      true    (如果两个值不相同，则异或结果为true)
 * !       NOT(非)         ！false         true
 * &&      AND(短路)     false && true     false
 * ||      OR(短路)      false || true     true
 *
 * <p>
 * 单&时，左边无论真假，右边都进行运算
 * 双&&时，如果左边为真，右边参与运算，如果左边为假，那么右边不参与运算。
 * | 和 || 的区别同理，双或时，左边为真，右边不参与运算。
 * 异或( ^ )与或( | )的不同之处是：当左右都为true时，结果为false
 * <p>
 * ------------位运算符------------------
 * <p>   位运算是直接对二进制进行运算
 * <p>
 * 运算符       运算                  示例                                  运算方式
 * <<          左移              3<<2 = 12 -> 3*2*2 = 12            空位补0，被移除的高位丢弃
 * >>          右移              3>>1 = 1  -> 3/2 = 1               被移除的二进制最高位是0，右移后补0，最高位是1则补1
 * >>>        无符号右移          3>>>1 = 1  -> 3/2 = 1              被移除的二进制最高位无论是0或1，空缺位都补0
 * &          与运算              6 & 3 = 2                          两个操作数中位都为1，结果才为1，否则结果为0
 * |          或运算              6 | 3 = 7                          两个操作数中位只要有一个为1，那么结果就是1，否则就为0
 * ^         异或运算             6 ^ 3 = 5                          两个操作数的位中，相同则结果为0，不同则结果为1
 * ~         反码(取反)            ~6 = -7                           如果位为0，结果是1，如果位为1，结果是0
 * <p>
 * <p>
 * ---------十进制负数转换为二进制---------
 * 如   -5 -> 1111 1011
 * 5转换二进制为 0000 0101
 * <p>
 * 原码                  0000 0101
 * 反码                  1111 1010
 * 补码(即反码加1)        1111 1011
 * <p>
 * 补码就是负数在计算机中的二进制表示方法
 * 那么，1111 1011表示8位的-5，
 * <p>
 * ---------负二进制负数转换为十进制---------
 * <p>
 * 如 1111 0011 ->  -13
 * <p>
 * 一个负数       1111 0011
 * 减一          1111 0010
 * 取反          0000 1101
 * 取反后转换为十进制得到 13,所以结果为-13
 * <p>
 * <p>
 * 在二进制码中，为了区分正负数，采用最高位是符号位的方法来区分，正数的符号位为0、负数的符号位为1。
 * 剩下的就是这个数的绝对值部分，可以采用原码、反码、补码3种形式来表示绝对值部分。
 * 原码就是绝对值的二进制数形式：例如+7的8位二进制原码是 0000 0111，-7的8位二进制原码是 1000 0111
 */
public class Base {

    public static void main(String[] args) {

        int a = 6;
        int b = 3;
        System.out.println("3<<2 的结果是" + (3 << 2));         //3 ->0000 0000 0000 0011, 所以结果是 0000 0000 0000 1100, 十进制的12
        System.out.println("3>>1 的结果是" + (3 >> 1));         //3 ->0000 0000 0000 0011, 所以结果是 0000 0000 0000 0001, 十进制的1
        System.out.println("3>>>1 的结果是" + (3 >>> 1));       //3 ->0000 0000 0000 0011, 所以结果是 0000 0000 0000 0001, 十进制的1
        System.out.println("a 和 b & 的结果是 " + (a & b));     //a -> 110 ,b -> 11,所以结果是 010  , 十进制的2
        System.out.println("a 和 b | 的结果是 " + (a | b));     //a -> 110 ,b -> 11,所以结果是 111, 十进制的7
        System.out.println("a 和 b ^ 的结果是 " + (a ^ b));     //a -> 110 ,b -> 11,所以结果是 101, 十进制的5
        System.out.println("~a  的结果是 " + ~a);               //a ->0000 0000 0000 0110 ,所以结果是 1111 1111 1111 1001, 转换为十进制-7

    }
}
