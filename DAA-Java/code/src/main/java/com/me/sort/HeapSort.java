package com.me.sort;

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
        for (int i = arr.length - 1; i >= 0 ; i--) { // O(N) 复杂度没有变化，只是第一步变快了
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
        int left = index << 1 + 1; // 左孩子的下标

        while (left < heapSize) { // 下方还有孩子的时候
            // 两个孩子中，谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父和较大孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) break;
            swap(arr, largest, index);
            index = largest;
            left = index << 1 + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 6};
        heapInsert(arr, 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
