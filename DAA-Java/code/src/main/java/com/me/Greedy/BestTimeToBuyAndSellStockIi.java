package com.me.Greedy;

import java.util.Arrays;

/**
 * 买卖股票的最佳时机 II
 * 
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockIi {

  public int maxProfit(int[] prices) {
    int sum = 0;
    int pur = -1; // 低价买入
    if (prices.length == 0) {
      return sum;
    }
    for (int i = 1; i < prices.length; i++) {
      if (pur == -1) {
        if (prices[i] > prices[i - 1]) { // 买入
          pur = prices[i - 1];
        }
      }
      if (pur != -1) {// 卖出
        if ((prices[i] < prices[i - 1])) {
          sum += prices[i - 1] - pur;
          pur = -1;
        } else if (i == prices.length - 1) {
          sum += prices[i] - pur;
          pur = -1;
        }
      }
    }
    return sum;
  }

  public void test() {
    int[] prices = {2, 1, 2, 0, 1};
    int i = maxProfit(prices);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new BestTimeToBuyAndSellStockIi().test();
  }

}
