package com.me.Recursion;

/**
 * @author zs
 * @date 2021/11/2
 */
public class GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
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
