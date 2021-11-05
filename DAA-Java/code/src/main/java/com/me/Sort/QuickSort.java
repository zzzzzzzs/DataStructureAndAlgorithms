package com.me.Sort;


/**
 * @author zs
 * @date 2021/10/12.
 * 快排
 */
public class QuickSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    // arr[1..r]排好序
    public static void quickSort(int[] arr, int L, int R) {
        if (L == R) return;
//        TODO if (L > R - 60) {
//            在arr[L..R]插入排序；
//            O(N^2) 小样本量的时候，跑得快；
//            return;
//         }
        swap(arr, L + (int) (Math.random() * R - L + 1), R); // 等概率随机选一个位置，把它和最后一个位置做交换
        int[] p = partition(arr, L, R); // 返回相等区域的左边界和右边界
        quickSort(arr, L, p[0] - 1); // < 区
        quickSort(arr, p[1] + 1, R); // > 区
    }

    // 这是一个处理arr[1..R]的函数
    // 默认以arr[r]做划分，arr[r] -> p   <p  ==p  >p
    // 返回等于区域（左边界，右边界）， 所以返回一个长度为2的数组res，res[0] res[1]
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;//  <区 右边界
        int more = R; // >区左边界
        while (L < more) { // L表示当前数的位置 arr[R] -> 划分值
            if (arr[L] < arr[R]) {//当前数 < 划分值
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) { // 当前数 > 划分值
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 6};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
