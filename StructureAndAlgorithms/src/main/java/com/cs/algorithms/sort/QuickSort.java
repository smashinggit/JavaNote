package com.cs.algorithms.sort;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/28 10:42
 * @description：快速排序
 * @modified By：
 * @version: $
 * 如果要排序数组中下标从 p 到 r 之间的一组数据,我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
 * 经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，前面 p 到 q-1 之间都是小于 pivot 的，
 * 中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
 * 根据分治、递归的处理思想，我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到
 * r 之间的数据，直到区间缩小为 1，就说明所有的数据都有序了
 *
 * <p>
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {11, 8, 3, 9, 7, 1, 2, 5};
//        int[] arr = {11, 8, 3};
        System.out.println("排序前");
        printAll(arr);

        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后");
        printAll(arr);
    }


    /**
     * 递推公式
     * Quick_Sort(start..end) = Quick_Sort(start..q-1) +Quick_Sort(q+1..end)
     * 终止条件
     * start>=end
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int q = partition(arr, start, end);
        quickSort(arr, start, q - 1);
        quickSort(arr, q + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;

        for (int j = start; j < end; j++) {

            if (arr[j] < pivot) {

                if (i == j) {
                    i++;
                } else {

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                }
            }
        }

        int tmp = arr[i];
        arr[i] = arr[end];
        arr[end] = tmp;

        System.out.println("i=" + i);
        return i;
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
