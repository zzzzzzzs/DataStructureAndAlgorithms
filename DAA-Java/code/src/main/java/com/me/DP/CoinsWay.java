package com.me.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zs
 * @date 2022/2/8 换零钱 给定一个正数数组，数组里面的数不重复 在给定一个目标数，求用数组里面的数拼凑成该目标数的方法数（数组里面的数可以多次使用）
 */
public class CoinsWay {

  // 暴力递归，按照题意分析就行
  // arr中都是正数且无重复值，返回组成aim的方法数
  public static int ways1(int[] arr, int aim) {
    // 返回 0 种方法
    if (arr == null || arr.length == 0 || aim < 0) {
      return 0;
    }
    return process1(arr, 0, aim);
  }

  // 如果自由使用arr[index...]的面值，组成rest这么多钱，返回方法数 （1 , 6）
  public static int process1(int[] arr, int index, int rest) {
    if (index == arr.length) { // 无面值的时候
      return rest == 0 ? 1 : 0;
    }
    // 方法数
    int ways = 0;
    // arr[index] 当钱面值
    for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
      ways += process1(arr, index + 1, rest - zhang * arr[index]);
    }
    return ways;
  }

  // 记忆化搜索
  // 先分析暴力递归有没有重复解，有
  public static int ways2(int[] arr, int aim) {
    // 返回 0 种方法
    if (arr == null || arr.length == 0 || aim < 0) {
      return 0;
    }
    // 用来缓存的
    int[][] dp = new int[arr.length + 1][aim + 1];
    // 一开始所有的过程，都没有计算
    // dp[..][..] = -1
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = -1;
      }
    }
    return process2(arr, 0, aim, dp);
  }

  // 自顶向下的动态规划，就是和递归的调用顺序一样。
  // 如果index和rest的参数组合，是没算过的，dp[index][rest] == -1
  // 如果index和rest的参数组合，是算过的，dp[index][rest] > - 1
  public static int process2(int[] arr, int index, int rest, int[][] dp) {
    // 计算过
    if (dp[index][rest] != -1) {
      return dp[index][rest];
    }
    if (index == arr.length) {
      // 将数据添加到缓存种
      dp[index][rest] = rest == 0 ? 1 : 0;
      return dp[index][rest];
    }
    // 方法数
    int ways = 0;
    // arr[index] 当钱面值
    for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
      ways += process2(arr, index + 1, rest - zhang * arr[index], dp);
    }
    dp[index][rest] = ways;
    return ways;
  }

  // 经典动态规划
  public static int ways3(int[] arr, int aim) {
    if (arr == null || arr.length == 0 || aim < 0) {
      return 0;
    }
    int N = arr.length;
    int[][] dp = new int[N + 1][aim + 1];
    dp[N][0] = 1; // dp[N][1..aim] = 0
    for (int index = N - 1; index >= 0; index--) { // 大顺序 从下往上
      for (int rest = 0; rest <= aim; rest++) {
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
          ways += dp[index + 1][rest - (zhang * arr[index])];
        }
        dp[index][rest] = ways;
      }
    }
    return dp[0][aim];
  }

  // 经典动态规划
  public static int waysdp(int[] arr, int aim) {
    if (arr == null || arr.length == 0 || aim < 0) {
      return 0;
    }
    int N = arr.length;
    int[][] dp = new int[N + 1][aim + 1];
    dp[N][0] = 1;
    for (int index = N - 1; index >= 0; index--) { // 大顺序 从下往上
      for (int rest = 0; rest <= aim; rest++) {
        dp[index][rest] = dp[index + 1][rest];
        if (rest - arr[index] >= 0) {
          dp[index][rest] += dp[index][rest - arr[index]];
        }
      }
    }
    return dp[0][aim];
  }

  public static void main(String[] args) {
    int[] arr = {5, 2, 3, 1};
    int sum = 350;
    System.out.println(ways1(arr, sum));
    System.out.println(ways2(arr, sum));
    System.out.println(ways3(arr, sum));
    System.out.println(waysdp(arr, sum));
  }
}
