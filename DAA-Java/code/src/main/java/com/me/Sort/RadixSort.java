package com.me.Sort;

import java.util.Arrays;

/**
 * @author zs
 * @date 2021/10/13.
 * 基数排序
 */
public class RadixSort {

    // only for no-megative value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // arr[L..R]排序, digit 表示最大的值有多少位
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10; // 以10位基底
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) { // 最大值有多少位就进出桶几次
            /*
            TODO 比如现在有[013,021,011,052,062]
                没有桶这个东西，是按照词频表来搞的，有一个长度为10的数组 count[]
                count[0,2,2,1,0,0,0,0,0,0]
                      0 1 2 3 4 5 6 7 8 9
                从个位数遍历：3位置词频是1，1位置词频是1，1位置词频变成2，2位置词频是1，2位置词频变成2，剩下的位置词频都是0
                也就是说2位置上表示个位数字等于2的数字有几个，3位置表示个位数字等于3的数字有几个
                将count数组加工一下，遍历累加前面的数字，变成前缀和数，count[0,2,4,5,5,5,5,5,5,5] -> [0,2,3,5,5,5,5,5,5,5]
                现在变成了2位置上个位数字小于等于2的数字有多少个，3位置上个位数字小于等于3的数字有多少个，
                |
                从右往左走，062在help中的的什么位置？看2位置小于等于2的数有4个，又是最右侧的，如果倒出来就应该在3位置，然后count对应位置2的数减一
                052小于等于2的数有3个，从右往左出桶，应该放在2位置上，然后count中位置2的数减一，然后继续这样做。
                有一个辅助数组，和原数组等规模 help[]
                help[013,021,011,052,062]
                我们用这个count数组可以做到分叉，从右往左根据count数组的值输出到help数组上去，等于完成了一次入桶出桶。
                依靠词频的减减，就能做到先入桶的先出桶。

             * 10个空间
             * count[0] 当前位(d位)是0数字有多少个
             * count[1] 当前位(d位)是(0和1)数字有多少个
             * count[2] 当前位(d位)是(0、1和2)数字有多少个
             * count[i] 当前位(d位)是(0~i)数字有多少个
             **/
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d); // d=1 个位 d=2 十位 d=3 百位
                count[j]++;
            }
            for (i = R; i >= L; i--) { // 数组从右往左遍历
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; j <= R; i++, j++) { // 把辅助数组的数导到原始数组中
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        radixSort(arr);
        printArray(arr);

    }
}
