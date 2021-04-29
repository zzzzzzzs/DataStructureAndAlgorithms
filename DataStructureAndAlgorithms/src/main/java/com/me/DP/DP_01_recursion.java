package com.me.DP;

import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLong;
import com.google.common.primitives.UnsignedLongs;
import org.joou.ULong;

import java.util.Calendar;

import static org.joou.Unsigned.ulong;

public class DP_01_recursion {

    /*
    TODO 斐波那契数列
    * */

    public static Long fibonacci(Long n) {
        if (1 == n) {
            return 1L;
        }
        if (2 == n) {
            return 2L;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static ULong Ufibonacci(long n) {
        if (1 == n) {
            return ulong(1L);
        }
        if (2 == n) {
            return ulong(2L);
        }

        return Ufibonacci(n -1 ).add(Ufibonacci(n - 2));
//        return Ufibonacci(n - 1) + Ufibonacci(n - 2);
    }

    public static void main(String[] args) {
        // 14254ms
//        long start1 = Calendar.getInstance().getTimeInMillis();
//        Ufibonacci(45L);
//        long end1 = Calendar.getInstance().getTimeInMillis();
//        System.out.println(end1 - start1);

        // long 7600ms Long 14889ms
        long start1 = Calendar.getInstance().getTimeInMillis();
        fibonacci(45L);
        long end1 = Calendar.getInstance().getTimeInMillis();
        System.out.println(end1 - start1);
    }
}
