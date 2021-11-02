package com.me.dichotomy;

public class BS_03_loopBinarySearch {
    /*
        TODO 二分法循环版本
    * */
    public static boolean loopBinarySearch(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == target) {
                return true;
            } else if (sortedArr[mid] > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == target;
    }

    public static void main(String[] args) {
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; ++i) {
            arr[i] = i;
        }
        System.out.println(loopBinarySearch(arr, 54321));
    }
}
