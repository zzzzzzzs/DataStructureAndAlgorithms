package com.me.DP;

/**
 * @author zs
 * @date 2022/2/17 Fibancci 数列
 */
public class Fibancci {

  // 1，1，2，3，5，8，13，21，34，55，89...
  // 这个数列从第3项开始，每一项都等于前两项之和。
  public static int f(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 1;
    }
    return f(n - 1) + f(n - 2);
  }

  public static void main(String[] args) {
    int f = f(3);
    System.out.println(f);
  }
}
