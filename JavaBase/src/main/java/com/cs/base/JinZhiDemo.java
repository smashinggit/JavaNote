package com.cs.base;


/**
 * 二进制
 * 由0,1组成。以0b开头
 * <p>
 * 八进制
 * 由0,1,…7组成。以0开头
 * <p>
 * 十进制
 * 由0,1,…9组成。整数默认是十进制的
 * <p>
 * 十六进制
 * 由0,1,…9,a,b,c,d,e,f(大小写均可)。以0x开头
 * <p>
 * <p>
 * <p>
 * ---------------------------------------------
 * 其他进制到十进制
 * 1、二进制（100）————>十进制（4）
 * 100 = 1*2² + 0*2^1 + 0*2^0 = 4+0+0 = 4
 * 2、八进制（100）————>十进制（64）
 * 100 = 1*8² + 0*8^1 + 0*8^0 = 64+0+0 = 64
 * 3、十六进制（100）————>十进制（256）
 * 100 = 1*16² + 0*16^1 + 0*16^0=256+0+0=256
 * <p>
 * 进制练习，得到下面数据的十进制值：
 * （1）0b10101
 * =1*2^4 + 1*2^2 + 1*2^0
 * =16 + 4 + 1
 * =21
 * （2）0123
 * =1*8^2 + 2*8^1 + 3*8^0
 * =64 + 16 + 3
 * =83
 * （3）0x3c
 * =3*16^1 + c*16^0
 * =48 + 12
 * =60
 * -----------------------------------------
 * <p>
 * -----------------------------------------
 * 十进制到其他进制（方法：除基取余，直到商为0，余数反转）
 * 1、十进制（20）————>二进制（？）
 * 首先我们来解释一下上面的方法怎么理解：
 * 20为十进制，要转为二进制，我们一定要记住余数，因为它最后就是我们的想要的答案，
 * 首先用20/2=10余0，10/2=5余0，5/2=2余1，2/2=1余0，1/2=0余1。
 * 余数反转，结果是：10100
 * 大家可以用上面二进制转十进制的方法来验证一下，1*2^4+1*^2²=20
 * -----------------------------------------
 */

public class JinZhiDemo {

    //输出不同进制下100的值
    public static void main(String[] args) {
        System.out.println(0b100); //二进制
        System.out.println(0100); //八进制
        System.out.println(100); //十进制
        System.out.println(0x100); //十六进制
    }
}
