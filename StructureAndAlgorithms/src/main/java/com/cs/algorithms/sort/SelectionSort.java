package com.cs.algorithms.sort;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/24 11:09
 * @description：选择排序
 * @modified By：
 * @version: $
 * 选择排序算法的实现思路有点类似插入排序,也分已排序区间和未排序区间
 * 但是选择排序每次会从未排序区间中找到最小的元素,将其放到已排序区间的末尾
 * <p>
 * 第一，选择排序是原地排序算法吗？
 * 选择排序空间复杂度为O(1),是原地排序算法
 * 第二，选择排序是稳定的排序算法吗？
 * 答案是否定的，选择排序是一种不稳定的排序算法
 * 选择排序每次都要找剩余未排序元素中的最小值，并和前面的元素交换位置，这样破坏了稳定性。
 * 正是因此，相对于冒泡排序和插入排序，选择排序就稍微逊色了
 * 第三，选择排序的时间复杂度是多少？
 * 最好情况下时间复杂度为O(n2) 。需要进行n次排序，每次排序中又要遍历一遍数组找到最小值
 * 最坏情况和平均情况时间复杂度都为 O(n2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 6, 4, 2, 1};

        System.out.println("排序前；");
        printAll(array);
        selectionSort(array);

        System.out.println("排序后；");
        printAll(array);
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public static void selectionSort(int[] array) {

        int n = array.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            //最小值的位置
            int minPos = i;
            //插入点的位置
            int selectPos = i;

            //找到未排序区间中的最小值的位置
            for (int j = i; j < n; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }

            int minValue = array[minPos];
            array[minPos] = array[selectPos];
            array[selectPos] = minValue;
            System.out.println("第" + (i + 1) + "次排序：");
            printAll(array);
        }
    }


    public static void printAll(int[] array) {

        StringBuilder result = new StringBuilder("array[ ");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i] + ", ");
        }
        result.append("]");
        System.out.println(result);
    }
}
