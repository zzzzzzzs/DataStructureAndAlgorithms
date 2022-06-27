package com.me.Other;

/**
 * 股票的最大利润
 *
 * <p>https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class GuPiaoDeZuiDaLiRunLcof {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int res = 0, min = prices[0];
    for (int num : prices) {
      if (min > num) {
        min = num;
      } else {
        res = Math.max(res, num - min);
      }
    }
    return res;
  }

  void test() {
    int[] prices = {2, 4, 1};
    int i = maxProfit(prices);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new GuPiaoDeZuiDaLiRunLcof().test();
  }
}
