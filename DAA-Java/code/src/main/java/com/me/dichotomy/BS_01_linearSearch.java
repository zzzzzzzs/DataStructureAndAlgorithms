package com.me.dichotomy;

public class BS_01_linearSearch {

    // TODO 线性搜索
    public static boolean linearSeatch(int[] arr, int tatget){
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] == tatget){
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
        System.out.println(linearSeatch(arr, 100000000));
    }
}
