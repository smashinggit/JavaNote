package com.cs.algorithms.sort;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/23 16:21
 * @description：冒泡排序
 * @modified By：
 * @version: $
 * <p>
 * 冒泡排序只会操作相邻的两个数据
 * 每次冒泡操作都会对相邻的两个元素进行比较,看是否满足大小关系要求
 * 如果不满足就让它俩互换.
 * 一次冒泡会让至少一个元素移动到它应该在的位置,重复 n 次，就完成了 n 个数据的排序工作。
 * <p>
 * 第一，冒泡排序是原地排序算法吗？
 * 冒泡的过程只涉及相邻数据的交换操作,只需要常量级的临时空间,
 * 所以它的空间复杂度为 O(1)，是一个原地排序算法
 * 第二，冒泡排序是稳定的排序算法吗？
 * 在冒泡排序中,只有交换才可以改变两个元素的前后顺序。
 * 为了保证冒泡排序算法的稳定性，当有相邻的两个元素大小相等的时候,我们不做交换，
 * 相同大小的数据在排序前后不会改变顺序，所以冒泡排序是稳定的排序算法。
 * 第三，冒泡排序的时间复杂度是多少？
 * 最好情况下，要排序的数据已经是有序的了,我们只需要进行一次冒泡操作.所以最好情况时间复杂度是 O(n)
 * 最坏的情况是,要排序的数据刚好是倒序排列的,我们需要进行 n 次冒泡操作，所以最坏情况时间复杂度为 O(n2)
 * 平均情况下的时间复杂度就是 O(n2)
 * <p>
 * 有序度
 * 是数组中具有有序关系的元素对的个数。表达式如下
 * 有序元素对：a[i] <= a[j], 如果 i < j
 * {2,4,3,1,5,6}  这组数据的有序度为11,因为其有序元素对为11个
 * {2,4}  {2,3}  {2,5}  {2,6}  {4,5}  {4,6}  {3,5}  {3,6}  {1,5}  {1,6}  {5,6}
 * 对于一个倒序排列的数组，比如 6，5，4，3，2，1，有序度是 0；
 * 对于一个完全有序的数组，比如 1，2，3，4，5，6，有序度就是n*(n-1)/2,也就是15
 * 完全有序的数组的有序度叫作满有序度
 * <p>
 * 逆序度
 * 的定义正好跟有序度相反（默认从小到大为有序）
 * 逆序元素对：a[i] > a[j], 如果 i < j。
 * <p>
 * 逆序度 = 满有序度 - 有序度
 * <p>
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] array0 = {6, 5, 4, 3, 2, 1};
        int[] array = {4, 5, 6, 3, 2, 1};
        int[] array2 = {1, 2, 3, 6, 5, 4};

        System.out.println("排序前；");
        printAll(array);
        bubbleSort(array);

        System.out.println("--------------------------");

        System.out.println("排序前；");
        printAll(array2);
        bubbleSort2(array2);

    }


    /**
     * @param array
     * @return
     */
    public static void bubbleSort(int[] array) {

        int n = array.length;
        if (n <= 1) {
            return;
        }

        //总共需要n-1次冒泡
        for (int i = 0; i < n - 1; i++) {

            int compareCount = 0;

            /**
             * 每次冒泡进行 (n - 1) - i次比较  i代表是第几轮冒泡，
             * 因为每冒泡一次至少有一个数据找到位置，所以减去轮数
             */
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];

                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                compareCount++;
            }

            System.out.println("第" + (i + 1) + "次排序共比较" + compareCount + "次，排序后");
            printAll(array);
        }
    }


    /**
     * 优化后的排序算法
     * 当某次冒泡操作已经没有数据交换时,说明已经达到完全有序，不用再继续执行后续的冒泡操作
     *
     * @param array
     */
    public static void bubbleSort2(int[] array) {

        int n = array.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {

            // 提前退出冒泡循环的标志位
            boolean flag = false;
            int compareCount = 0;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];

                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //表示有数据交换
                    flag = true;
                }
                compareCount++;
            }
            System.out.println("第" + (i + 1) + "次排序共比较" + compareCount + "次，排序后");
            printAll(array);

            //没有数据交换，提前退出
            if (!flag) {
                System.out.println("没有数据交换，提前退出");
                break;
            }
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
