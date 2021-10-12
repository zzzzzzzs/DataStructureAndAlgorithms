package com.me;

import javax.swing.plaf.basic.BasicArrowButton;

/**
 * @author zs
 * @date 2021/10/12.
 * 小和问题
 */
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求小和
    public static int process(int[] arr, int L, int R) {
        if (L == R) return 0;
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) // 左侧排序并且求小和的数量
                + process(arr, mid + 1, R)  // 右侧排序并且求小和的数量
                + merge(arr, L, mid, R); // 左侧拍好，右侧拍好求小和的数量
    }

    public static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + L;
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0; // 只有左组比右组小才右增加的行为
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
