package com.me.Sort;

import java.util.Arrays;

/**
 * @author zs
 * @date 2021/10/12.
 *
 */
public class HeapSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        // 将数组整体搞成大顶堆
//        for (int i = 0; i < arr.length; i++) { // O(N)
//            heapInsert(arr, i); // O(logN)
//        }
        for (int i = arr.length - 1; i >= 0; i--) { // O(N) 复杂度没有变化，只是第一步变快了
            heapify(arr, i, arr.length);
        }


        int heapSize = arr.length;
        swap(arr, 0, --heapSize); //将0位置上的数和最后一个位置上的数进行交换
        while (heapSize > 0) {
            heapify(arr, 0, heapSize); // O(logN)
            swap(arr, 0, --heapSize); //O(1)
        }
    }

    // 某个数现在处在index位置，往上继续移动
    public static void heapInsert(int[] arr, int index) {
        int fIndex = (index - 1) >> 1; // 父位置
        while (arr[index] > arr[fIndex]) { //当前的数如果大于父位置的数。一个while包含了2个停止条件：头位置或者不比父大了
            swap(arr, index, fIndex); // index的数和父位置的数做交换
            index = fIndex;
        }
    }

    // -ify 后缀，化
    // 某个数在index位置，能否往下移动
    // heapSize管着是否越界以及堆的大小
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) + 1; // 左孩子的下标
        while (left < heapSize) { // 下方还有孩子的时候
            // 两个孩子中，谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父和较大孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) break;
            swap(arr, largest, index);
            index = largest;
            left = (index << 1) + 1;
        }
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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

    // for test 对数器
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}
