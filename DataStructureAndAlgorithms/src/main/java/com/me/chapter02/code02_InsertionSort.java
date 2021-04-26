package com.me.chapter02;


import java.util.ArrayList;

// TODO 插入算法
/*
    要求
    输入:n个数的一个序列<a1, a2, a3, a4...an>。
    输出:输入序列的一个排列<a1', a2', a3', ... an'>，满足a1'<=a2'<=a3'...<=an'

* */
public class code02_InsertionSort {
    public static void main(String[] args) {
        int[] arrs = new int[]{5, 2, 4, 6, 1, 3};

        for (int i = 1; i < arrs.length; i++) {
            int key = arrs[i];
            // 将此时的元素插入到排序的序列中
            int j = i - 1;
            while (j > 0 && arrs[j] > key){
                arrs[j+1] = arrs[j];
                j = j -1;
            }
            arrs[j+1] = key;
        }

        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }

    }
}
