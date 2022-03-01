package com.me.DP;

/**
 *
 * 斐波那契数
 *
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class FibonacciNumber {

  // 迭代，自底向上
  int fib(int N) {
    if (N == 0)
      return 0;
    int[] dp = new int[N + 1];
    // base case
    dp[0] = 0;
    dp[1] = 1;
    // 状态转移
    for (int i = 2; i <= N; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[N];
  }

  // 记忆化搜索，自顶向下
  int fib2(int n) {
    // 备忘录全初始化为 0
    int[] cache = new int[n + 1];
    // 进行带备忘录的递归
    return helper(cache, n);
  }

  int helper(int[] cache, int n) {
    // base case
    if (n == 0 || n == 1)
      return n;
    // 已经计算过，不用再计算了
    if (cache[n] != 0)
      return cache[n];
    cache[n] = helper(cache, n - 1) + helper(cache, n - 2);
    return cache[n];
  }

  // 递归
  public int fib1(int n) {
    if (n < 2)
      return n;
    return fib1(n - 1) + fib1(n - 2);
  }

  void test() {
    int fib = fib2(2);
    System.out.println(fib);
  }

  public static void main(String[] args) {
    new FibonacciNumber().test();
  }
}
