package com.cs.algorithms.recursion;

import java.util.HashMap;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/23 11:00
 * @description：递归
 * @modified By：
 * @version: $
 * <p>
 * 写递归代码的关键就是找到如何将大问题分解为小问题的规律，
 * 并且基于此写出递推公式，然后再推敲终止条件，最后将递推公式和终止条件翻译成代码
 * <p>
 * 一个问题只要同时满足以下3个条件，就可以用递归来解决：
 * 1.问题的解可以分解为几个子问题的解。何为子问题？就是数据规模更小的问题。
 * 2.问题与子问题，除了数据规模不同，求解思路完全一样
 * 3.存在递归终止条件
 * <p>
 * 递归常见问题及解决方案
 * 1.警惕堆栈溢出：可以声明一个全局变量来控制递归的深度，从而避免堆栈溢出。
 * 2.警惕重复计算：通过某种数据结构来保存已经求解过的值，从而避免重复计算。
 */
public class Recursion {

    public static void main(String[] args) {

        System.out.println("递归求5的阶乘 " + jiecheng(5));
        System.out.println("不用递归求5的阶乘 " + jiecheng2(5));
        System.out.println();

        System.out.println("递归求第几排 " + getRow(5));
        System.out.println("不用递归求第几排 " + getRow2(5));
        System.out.println();


        System.out.println("递归求n阶台阶的走法 " + getMethods(6));
        System.out.println("递归求n阶台阶的走法(避免重复计算) " + getMethods2(6));
        System.out.println("不用递归求n阶台阶的走法 " + getMethods3(6));
        System.out.println();





    }


    /**
     * 递归求n的阶乘
     * 递推公式:
     * f(n) = n * f(n-1)
     * 终止条件:
     * f(1) = 1
     *
     * @param n
     * @return
     */
    public static int jiecheng(int n) {

        if (n == 1) {
            return 1;
        }
        return n * jiecheng(n - 1);
    }

    /**
     * 不用递归，求n的阶乘
     * 终止条件，n=1
     *
     * @param n
     * @return
     */
    public static int jiecheng2(int n) {
        int result = 1;
        for (int i = n; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }


    /**
     * 周末你带着女朋友去电影院看电影，女朋友问你，咱们现在坐在第几排啊？电影院里面太黑了，
     * 看不清，没法数，现在你怎么办？
     * 递归就开始排上用场了.于是你就问前面一排的人他是第几排.你想只要在他的数字上加一，就知道自己在哪一排了
     * 但是，前面的人也看不清啊，所以他也问他前面的人.就这样一排一排往前问，直到问到第一排的人说我在第一排，
     * 然后再这样一排一排再把数字传回来
     * 去的过程叫“递”，回来的过程叫“归”
     * <p>
     * 递归公式
     * f(n) = f(n-1)+1
     * 终止条件
     * f(1) = 1
     *
     * @param n
     * @return
     */
    public static int getRow(int n) {
        if (n == 1) {
            return 1;
        }
        return getRow(n - 1) + 1;
    }

    /**
     * @param n
     * @returnn
     */
    public static int getRow2(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result = result + 1;
        }
        return result;
    }

    /**
     * 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个个台阶，请问走这 n 个台阶有多少种走法？
     * 实际上，可以根据第一步的走法把所有走法分为两类
     * 第一类是第一步走了 1 个台阶
     * 另一类是第一步走了 2 个台阶
     * 所以 n 个台阶的走法就等于先走 1 阶后 n-1 个台阶的走法 加上 先走 2 阶后 n-2 个台阶的走法
     * 递推公式
     * f(n) = f(n-1)+f(n-2)
     * 终止条件
     * f(1) = 1
     * f(2) = 2
     * <p>
     * <p>
     * <p>
     * 如果我们要上一个N级台阶的楼梯，每次只能走1格或者2格，那么一共有多少种走法呢？
     * 如果只有一级台阶，显然只有1种走法。
     * 如果有两级台阶，显然可以走一步，也可以走两步，因此有2种走法。
     * 如果有三级台阶，就有如图所示的3种走法. 1-1-1  1-2  2-1
     * 由于一步最多走连两个台阶，因此要到达第N级台阶，有两种方案：
     * 走到第N-1级台阶上，然后走1级台阶跨到最上方；
     * 走到第N-2级台阶上，然后一步走两级台阶跨到最上方。
     * 注意，从第N-2级台阶走1级到N-1级台阶这种情况已经计算在第一种情况中计算过了。
     * 由上可得到递推公式为
     * f(n) = f(n-1)+f(n-2)
     * <p>
     * 我们用an表示一个数列的第n项，那么斐波那契数列的规律就是
     * a(n)=a(n-1) + a(n-2)   即前两项之和等于后一项
     * 除了最初几个数字不一样之外，
     * 后面都是按照1、1、2、3、5、8、13…变化的，这个数列就称为兔子数列或者斐波那契数列
     *
     * @param n
     * @return
     */
    public static int getMethods(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return getMethods(n - 1) + getMethods(n - 2);
    }


    /**
     * 计算f(5)需要计算f(4)和f(3),而计算f(4)又需要计算f(3)和f(2)
     * ，因此，f(3)就被计算了很多次
     * 为了避免重复计算，我们可以通过一个数据结构（比如散列表））来保存已经求解过的 f(k)
     * 当递归调用到 f(k) 时，先看下是否已经求解过了
     * 如果是，则直接从散列表中取值返回，不需要重复计算
     *
     * @param i
     * @return
     */

    private static HashMap<Integer, Integer> hashMap = new HashMap<>();

    private static int getMethods2(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }

        int result = getMethods(n - 1) + getMethods(n - 2);
        hashMap.put(n, result);
        return result;
    }


    /**
     * 不用阶乘求n级台阶的走法
     * pre即 f(n-1)
     * prepre即 f(n-2)
     *
     * @param n
     * @return
     */
    public static int getMethods3(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int result = 0;
        int pre = 2;
        int prepre = 1;

        for (int i = 3; i <= n; i++) {
            result = pre + prepre;

            prepre = pre;
            pre = result;
        }
        return result;
    }

}
