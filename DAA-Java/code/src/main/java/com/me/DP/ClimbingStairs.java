package com.me.DP;

/**
 *
 * 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/
 */
public class ClimbingStairs {

  // 记忆化搜索，自顶向下
  public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    return helper(dp, n);
  }

  int helper(int[] dp, int n) {
    if (n <= 2)
      return n;
    if(dp[n] != 0) return dp[n];
    dp[n] = helper(dp, n - 1) + helper(dp, n - 2);
    return dp[n];
  }


  // 暴力递归
  public int climbStairs1(int n) {
    if (n <= 2)
      return n;
    return climbStairs1(n - 1) + climbStairs1(n - 2);
  }

  void test() {
    int i = climbStairs(45);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new ClimbingStairs().test();
  }
}
