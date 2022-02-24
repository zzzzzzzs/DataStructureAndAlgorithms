package com.me.leetcode;

/**
 * 统计各位数字之和为偶数的整数个数
 */
public class lc_2180 {
  public int countEven(int num) {
    int count = 0;
    if (num <= 0) {
      return count;
    }

    for (int i = 1; i <= num; i ++) {
      int sum = (i / 1000) + (i / 100) + (i % 100 / 10) + (i % 10);
      if (sum % 2 == 0) {
        System.out.println(i);
        count++;
      }
    }
    return count;
  }

  void test() {
    int i = countEven(4);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new lc_2180().test();
  }
}
