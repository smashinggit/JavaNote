package com.cs.algorithms.search;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/29 14:16
 * @description：二分查找
 * @modified By：
 * @version: $
 * <p>
 * 二分查找的时间复杂度是 O(logn),查找数据的效率非常高
 * <p>
 * 四种二分查找的变形
 * 变体一：查找第一个值等于给定值的元素
 */

public class BinarySearch {

    public static void main(String[] args) {

        int[] simpleArr = {1, 5, 7, 9, 15, 20, 26, 50, 52, 56, 58, 66, 67, 69, 82, 92, 95, 98, 99};
        System.out.println("最简单的二分查找法 查找结果为 " + simpleBinarySearch(simpleArr, 1));
        System.out.println("递归实现最简单的二分查找法 查找结果为 " +
                simpleBinarySearchBaseOnRecursion(simpleArr, 0, simpleArr.length - 1, 56));


        //变体一：查找第一个值等于给定值的元素
        int[] arr1 = {1, 2, 3, 8, 8, 8, 9, 10, 11, 12, 16};
        System.out.println("二分查找法变形一: 查找第一个值等于给定值的元素 " +
                binarySearch1(arr1, 8));

        //变体二：查找最后一个值等于给定值的元素
        System.out.println("二分查找法变形二: 查找最后一个值等于给定值的元素 " +
                binarySearch2(arr1, 8));

        //变体三：查找第一个大于等于给定值的元素
        System.out.println("二分查找法变形三: 查找第一个值大于等于给定值的元素 " +
                binarySearch3(arr1, 4));

        //变体四：查找最后一个小于等于给定值的元素
        System.out.println("二分查找法变形四: 查找最后一个小于等于给定值的元素 " +
                binarySearch4(arr1, 4));

    }

    /**
     * 变体一：查找第一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch1(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                //当arr[mid]==value时
                //mid == 0或者mid的前一个数据不等于value,说明mid上的值为第一个要查找的值
                if (mid == 0 || arr[mid - 1] != value) {
                    return mid;
                } else {
                    //如果mid前一个值也等于要查找的值，则将返回缩小到low~mid-1，继续查找
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 变体二：查找最后一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch2(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 变体三：查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch3(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (arr[mid] >= value) {
                if (mid == 0 || (arr[mid - 1] < value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体四：查找最后一个小于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch4(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (arr[mid] <= value) {
                if (mid == arr.length - 1 || (arr[mid + 1] > value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 最简单的二分查找法
     * 1.有序数组
     * 2.没有重复值
     *
     * @param arr
     * @param value
     * @return
     */
    public static int simpleBinarySearch(int[] arr, int value) {

        int low = 0;
        int high = arr.length - 1;


        //注意是 <=  (当查找的数在最两端且数组长度为偶数时，最后一步计算时low==high)
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 递归方式实现简单二分法
     *
     * @param arr
     * @param low
     * @param height
     * @param value
     * @return
     */
    public static int simpleBinarySearchBaseOnRecursion(int[] arr, int low, int height, int value) {
        if (low > height) {
            return -1;
        }

        int mid = low + (height - low) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return simpleBinarySearchBaseOnRecursion(arr, mid + 1, height, value);
        } else {
            return simpleBinarySearchBaseOnRecursion(arr, mid, height - 1, value);
        }
    }

}
