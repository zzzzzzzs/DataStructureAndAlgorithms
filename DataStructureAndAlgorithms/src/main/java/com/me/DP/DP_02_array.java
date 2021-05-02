package com.me.DP;

import java.util.Calendar;

public class DP_02_array {


    /*
    TODO 由于递归版本会重复计算
        根据规律使用循环版本，这样做的目的就是将计算的结果缓存起来，不用重复计算了。预聚合，Flink的累加器也是这样的原理。
    * */
    public static long fibonacciArray(int n) {
        if (n == 1 || n == 2) {
            return (long)n;
        }
        long[] arr = new long[n + 1];
        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 2L;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        long start1 = Calendar.getInstance().getTimeInMillis();
        long fibonacci = fibonacciArray(1000);
        long end1 = Calendar.getInstance().getTimeInMillis();
        System.out.println("结果：" + fibonacci);
        System.out.println("需要的时间：" + (end1 - start1));
    }
}
