package com.me.DP;

/**
 * 剑指 Offer 47. 礼物的最大价值
 *
 * <p>https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class LiWuDeZuiDaJieZhiLcof {

  // 下[i+1][j]，右[i][j+1]
  public int maxValue(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] dp = new int[n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
      }
    }
    return dp[n];
  }

  void test() {
    int[][] arr = {
      {1, 3, 1},
      {1, 5, 1},
      {4, 2, 1}
    };
    int i = maxValue(arr);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new LiWuDeZuiDaJieZhiLcof().test();
  }
}
