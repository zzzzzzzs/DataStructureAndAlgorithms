package com.me.Sort;

import java.io.BufferedWriter;

/**
 * @author zs
 * @date 2021/10/7.
 * TODO 分治法：每层递归有三个步骤
 *      1、分解， 将大问题分解成小问题
 *      2、解决， 子问题规模足够小，直接求解
 *      3、合并， 子问题的解成原问题的解
 */
public class MergeSort {
    /**
     * TODO 归井排序算法完全遵循分治模式。直观上其操作如下：
     *  1、分解：分解待排序的 n 个元素的序列成各具 n/2 个元素的两个子序列。
     *  2、解决：使用归并排序递归地排序两个子序列。
     *  3、合井：合并两个巳排序的子序列以产生已排序的答案。
     **/
    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
//        int[] tmp = new int[nums.length];
        process(arr, 0, arr.length);
        BufferedWriter bufferedWriter = new BufferedWriter("a.txt");
        bufferedWriter.write();
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) { // 只有1个数直接返回
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    // 将arr的数据分成2部分
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1]; // 辅助空间，一共多少个数就开多大
        int i = 0; // 给help使用的变量指针，表示i位置上要填数
        int p1 = L; // 表示左侧部分的下标
        int p2 = M + 1; // 表示右侧部分的下标
        while (p1 <= M && p2 <= R) { // 都没越界，谁小就拷贝到help中，然后将p指针移动
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2 ++];
        }
        // 下面的2个while只会中一个
        while (p1 <= M) { // 如果p1没有越界，就把p1剩下的东西拷贝到help中
            help[i++] = arr[p1++];
        }
        while (p2 <= R) { // 如果p2没有越界，就把p2剩下的东西拷贝到help中
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) { // 将help中的数据拷贝会原数组中
            arr[L + 1] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {19, 15, 37, 12, 25};
        mergeSort(nums);
    }
}
