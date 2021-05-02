package com.me.DP;

import java.util.Calendar;


/*
TODO 斐波那契数列
* */
public class DP_01_recursion {



    /*
    TODO 递归版本，这个返回的时候有2个返回值，这样的话计算结果就会被重复计算
        fib(100) = fib(99) + fib(98) = 2 * fib(98) + fib(97)
        fib(4) = fib(3) + fib(2) = fib(2) + fib(1) + fib(2) =
    * */
    public static long fibonacciRec(long n) {
        if (1 == n || 2 == n) {
            return 1L;
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }


    public static void main(String[] args) {
        long start1 = Calendar.getInstance().getTimeInMillis();
        long fibonacci = fibonacciRec(45L);
        long end1 = Calendar.getInstance().getTimeInMillis();
        System.out.println("结果：" + fibonacci);
        System.out.println("需要的时间：" + (end1 - start1));
    }
}
