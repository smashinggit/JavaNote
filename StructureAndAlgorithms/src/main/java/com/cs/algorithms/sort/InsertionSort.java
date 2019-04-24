package com.cs.algorithms.sort;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/23 17:48
 * @description：插入排序
 * @modified By：
 * @version: $
 * <p>
 * 插入排序也包含两种操作
 * 一种是元素的比较
 * 一种是元素的移动
 * 当我们需要将一个数据 a 插入到已排序区间时，需要拿 a 与已排序区间的元素依次比较大小，找到合适的插入位置
 * 找到插入点之后，我们还需要将插入点之后的元素顺序往后移动一位,这样才能腾出位置给元素 a 插入
 * <p>
 * 对于不同的查找插入点方法（从头到尾、从尾到头）,元素的比较次数是有区别的.
 * 但对于一个给定的初始序列，移动操作的次数总是固定的,就等于逆序度。
 * <p>
 * 第一，插入排序是原地排序算法吗？
 * 插入排序算法的运行并不需要额外的存储空间，所以空间复杂度是 O(1)
 * 也就是说，这是一个原地排序算法
 * 第二，插入排序是稳定的排序算法吗？
 * 在插入排序中，对于值相同的元素，我们可以选择将后面出现的元素，
 * 插入到前面出现元素的后面。这样就可以保持原有的前后顺序不变，所以插入排序是稳定的排序算法。
 * 第三，插入排序的时间复杂度是多少？
 * 如果要排序的数据已经是有序的，我们并不需要搬移任何数据
 * 我们从尾到头在有序数据组里面查找插入位置，每次只需要比较一个数据就能确定插入的位置
 * 所以这种情况下，最好是时间复杂度为 O(n)。注意，这里是从尾到头遍历已经有序的数据
 * 如果数组是倒序的，每次插入都相当于在数组的第一个位置插入新的数据。
 * 所以需要移动大量的数据，所以最坏情况时间复杂度为 O(n2)。
 * 数组中插入一个数据的平均时间复杂度是多少吗？没错，是 O(n)
 * 所以，对于插入排序来说，每次插入操作都相当于在数组中插入一个数据，循环执行 n 次插入操作，
 * 所以平均时间复杂度为 O(n2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 6, 4, 2, 1};

        System.out.println("排序前；");
        printAll(array);
        insertionSort(array);

        System.out.println("排序后；");
        printAll(array);
    }


    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertionSort(int[] array) {

        int n = array.length;
        if (n <= 1) {
            return;
        }

        //从数组的第2个位置开始，依次与前面的已排序区间进行比较
        for (int i = 1; i < n; i++) {

            //当前进行插入的值
            int value = array[i];

            //插入点
            int j = i - 1;

            //从已排序区间尾部开始，依次与插入值进行比较。
            for (; j >= 0; j--) {

                if (array[j] > value) {
                    //将array[j]后移一位
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            //将数据插入
            array[j + 1] = value;
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
