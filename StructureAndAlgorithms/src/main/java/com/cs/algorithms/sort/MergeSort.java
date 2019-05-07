package com.cs.algorithms.sort;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/25 15:53
 * @description：归并排序
 * @modified By：
 * @version: $
 * <p>
 * 第一，归并排序是稳定的排序算法吗？
 * 归并排序稳不稳定关键要看 merge() 函数
 * 归并排序是一个稳定的排序算法
 * 第二，归并排序的时间复杂度是多少？
 * 归并排序的时间复杂度是 O(nlogn)
 * 第三，归并排序的空间复杂度是多少？
 * 归并排序的时间复杂度任何情况下都是 O(nlogn)，看起来非常优秀。
 * 但是，归并排序并没有像快排那样应用广泛
 * 因为它有一个致命的“弱点”，那就是归并排序不是原地排序算法
 * 递归代码的空间复杂度并不能像时间复杂度那样累加
 * 尽管每次合并操作都需要申请额外的内存空间,但在合并完成之后，临时开辟的内存空间就被释放掉了
 * 在任意时刻，CPU 只会有一个函数在执行,也就只会有一个临时的内存空间在使用
 * 临时内存空间最大也不会超过 n 个数据的大小,所以空间复杂度是 O(n)。
 */
public class MergeSort {
    public static void main(String[] args) {

//        int[] arr = {11, 8, 3, 9, 7, 1, 2, 5};
        int[] arr = {11, 8, 3};
        System.out.println("排序前");
        printAll(arr);

        mergeSort(arr, 0, arr.length - 1);
//        mergeSortInternally(arr, 0, arr.length - 1);
        System.out.println("排序后");
        printAll(arr);
    }


    /**
     * 递推公式
     * mergeSort(p..r) = merge( mergeSort(p..q),mergeSort(q+1,..r) )
     * 终止条件
     * p>=r 不用再继续分解
     *
     * @param arr
     * @param start 数组的头下标
     * @param end   数组的尾下标
     */
    public static void mergeSort(int[] arr, int start, int end) {
        // 递归终止条件
        if (start >= end) {
            return;
        }

        // 取start到end之间的中间位置mid
        int mid = start + (end - start) / 2;

        // 分治递归
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(arr, start, mid, end);
    }

    /**
     * @param arr
     * @param start 起始下标
     * @param mid   中间点下标
     * @param end   末尾下标
     */
    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;

        //申请一个大小跟a[start...end]一样的临时数组.
        int[] temp = new int[end - start + 1];

        while (i <= mid && j <= end) {

            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        // 判断哪个子数组中有剩余的数据
        int leftStart = i;
        int leftEnd = mid;
        if (j <= end) {
            leftStart = j;
            leftEnd = end;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (leftStart <= leftEnd) {
            temp[k] = arr[leftStart];
            k++;
            leftStart++;
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (int m = 0; m <= end - start; m++) {
            arr[start + m] = temp[m];
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
