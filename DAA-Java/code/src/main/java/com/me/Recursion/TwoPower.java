package com.me.Recursion;

/**
 * @author zs
 * @date 2022/2/20 2 的幂 https://leetcode-cn.com/problems/power-of-two/
 */
public class TwoPower {


  public boolean isPowerOfTwo(int n) {
    if (n == 1) {
      return true;
    }
    if (n == 0) {
      return false;
    }

    if (n % 2 == 0) {
      n = n / 2;
      return isPowerOfTwo(n);
    } else
      return false;
  }

  public void test() {
    boolean powerOfTwo = isPowerOfTwo(3);
    System.out.println(powerOfTwo);
  }

  public static void main(String[] args) {
    new TwoPower().test();
  }
}
