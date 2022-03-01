package com.me.DP;

/**
 *
 * 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

  public int coinChange(int[] coins, int amount) {
    if (amount == 0)
      return 0;
    if (amount < 0)
      return -1;
    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
      int sub = coinChange(coins, amount - coin);
      if (sub == -1)
        continue;
      res = Math.min(res, sub + 1);
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  void test() {
    int[] arr = {1, 2, 5};
    int i = coinChange(arr, 11);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new CoinChange().test();
  }
}
