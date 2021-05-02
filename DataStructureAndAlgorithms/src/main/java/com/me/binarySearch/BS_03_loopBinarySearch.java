package com.me.binarySearch;

public class BS_03_loopBinarySearch {
    /*
        TODO 二分法循环版本
    * */
    public static boolean loopBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; ++i) {
            arr[i] = i;
        }
        System.out.println(loopBinarySearch(arr, 54321));
    }
}
