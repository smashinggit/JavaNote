package com.cs.algorithms.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/24 14:31
 * @description：
 * @modified By：
 * @version: $
 * 一、排序方法与复杂度归类
 * （1）几种最经典、最常用的排序方法：冒泡排序、插入排序、选择排序、快速排序、归并排序、计数排序、基数排序、桶排序。
 * （2）复杂度归类
 * 冒泡排序、插入排序、选择排序 O(n^2)
 * 快速排序、归并排序 O(nlogn)
 * 计数排序、基数排序、桶排序 O(n)
 * 二、如何分析一个“排序算法”？
 * <1>算法的执行效率
 * 1. 最好、最坏、平均情况时间复杂度。
 * 2. 时间复杂度的系数、常数和低阶。
 * 3. 比较次数，交换（或移动）次数。
 * <2>排序算法的稳定性
 * 1. 稳定性概念：如果待排序的序列中存在值相等的元素，经过排序之后，相等元素之间原有的先后顺序不变。
 * 2. 稳定性重要性：可针对对象的多种属性进行有优先级的排序。
 * 3. 举例：给电商交易系统中的“订单”排序，按照金额大小对订单数据排序，对于相同金额的订单以下单时间早晚排序。用稳定排序算法可简洁地解决。先按照下单时间给订单排序，排序完成后用稳定排序算法按照订单金额重新排序。
 * <3>排序算法的内存损耗
 * 原地排序算法：特指空间复杂度是O(1)的排序算法。
 * <p>
 * 选择排序和插入排序的时间复杂度相同，都是O(n^2)，在实际的软件开发中，为什么我们更倾向于使用插入排序而不是冒泡排序算法呢？
 * 答：从代码实现上来看，冒泡排序的数据交换要比插入排序的数据移动要复杂，冒泡排序需要3个赋值操作，而插入排序只需要1个，
 * 所以在对相同数组进行排序时，冒泡排序的运行时间理论上要长于插入排序
 * <p>
 * 冒泡、插入、选择排序都有一个共同点，将待排序数列分为已排序和未排序两部分。
 * 在未排序的部分中查找一个最值，放到已排序数列的恰当位置
 * 具体到代码层面，外层循环的变量用于分割已排序和未排序数，内层循环的变量用于在未排序数中查找。
 * 从思路上看，这三种算法其实是一样的，所以时间复杂度也相同。
 */
public class Sort {

    public static void main(String[] args) {


        BubbleSortCompareWithInsertionSort();
    }

    /**
     * 冒泡排序和插入排序耗时对比
     */
    private static void BubbleSortCompareWithInsertionSort() {


        ArrayList<int[]> list = new ArrayList<>(1000);
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int[] arr = new int[100];

            for (int j = 0; j < 100; j++) {
                arr[j] = random.nextInt(1000);
            }

            list.add(arr);
        }
        ArrayList<int[]> cloneList = (ArrayList) list.clone();


        double now = System.currentTimeMillis();

        for (int[] arr : list) {
            BubbleSort.bubbleSort2(arr);
        }
        System.out.println("冒泡排序完成，耗时 " + (System.currentTimeMillis() - now));


        double now2 = System.currentTimeMillis();
        for (int[] arr : cloneList) {
            InsertionSort.insertionSort(arr);
        }
        System.out.println("插入排序完成，耗时 " + (System.currentTimeMillis() - now2));


    }


}
