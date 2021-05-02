package com.me.DP;

import java.util.Calendar;
import java.util.HashMap;

public class DP_03_HashMap {


    /*
    TODO 为了使用递归的方法求解（递归写起来方便），使用HashMap提前将数据缓存起来
        使用缓存
        时间复杂度为O(N)
    * */
    public static HashMap<Integer, Long> cache = new HashMap<>();
    public static long cachedFibonacci(int n) {
        if (!cache.containsKey(n)) {
            cache.put(n, fibHelp(n));
        }
        return cache.get(n);
    }
    public static long fibHelp(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return cachedFibonacci(n - 1) + cachedFibonacci(n - 2);
    }

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        System.out.println(cachedFibonacci(1000));
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println(end - start);
    }
}
