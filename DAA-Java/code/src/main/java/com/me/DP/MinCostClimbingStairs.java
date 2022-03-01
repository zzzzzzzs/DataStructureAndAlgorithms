package com.me.DP;

/**
 *
 * 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/
 */
public class MinCostClimbingStairs {

  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length];
    dp[0] = cost[0];
    dp[1] = cost[1];
    for (int i = 2; i < cost.length; i++) {
      dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
    }
    return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
  }

  void test() {
    int[] arr = {10, 15, 20};
    int i = minCostClimbingStairs(arr);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new MinCostClimbingStairs().test();
  }
}
