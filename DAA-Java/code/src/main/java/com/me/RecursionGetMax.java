package com.me;

/**
 * @author zs
 * @date 2021/10/11.
 *
 */
public class RecursionGetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]范围上求最大值     N
    public static int process(int[] arr, int L, int R) {
        if (L == R) { // arr[L..R]范围上只有一个数，直接返回，base case
            return arr[L];
        }
        int mid = L + ((R - L) >> 1); // 中点
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 6};
        int max = getMax(arr);
        System.out.println(max);
    }
}
