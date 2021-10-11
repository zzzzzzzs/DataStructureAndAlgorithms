package com.me;

/**
 * @author zs
 * @date 2021/10/11.
 */
public class EventTimesOddTImes {

    // 找出出现了一种数，出现了奇数次的数
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    // 找出出现了2种奇数次的数
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        // eor = a ^ b
        // eor != 0
        // eor 必然有一个位置上是1
        int rightOne = eor & (~eor + 1); //提取出最右的1
        int onlyOne = 0; // eor'
        for (int cur : arr) {
            if ((cur & rightOne) == 0) { //取出1个数
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 3, 1, 3, 3, 2};
        int[] arr2 = {2, 1, 3, 1, 3, 1, 3, 2};
        printOddTimesNum1(arr1);
        printOddTimesNum2(arr2);
    }
}
