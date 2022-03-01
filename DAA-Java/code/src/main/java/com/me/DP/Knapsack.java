package com.me.DP;

/**
 * 给定两个长度都为N的数组weights和values，
 * weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少?【不可分】
 * <p>
 * 尝试模型：
 * 从左往右尝试模型
 * [0 1 2] 0号要还是不要，1号要还是不要，2号要还是不要。路线是一个二叉树
 */
public class Knapsack {
    public static int maxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }

    // 暴力递归
    // 只剩下rest的空间了，
    // index...货物自由选择，但是不要超过rest的空间
    // 返回能够获得的最大价值
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) { // base case 1
            return -1;
        }
        // rest >=0
        if (index == w.length) { // base case 2
            return 0;
        }
        // 有货也有空间
        int p1 = process(w, v, index + 1, rest);
        int p2 = -1;
        int p2Next = process(w, v, index + 1, rest - w[index]);
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    // 改成动态规划
    public static int dpWay(int[] w, int[] v, int bag) {
        int N = w.length;
        // 用来缓存的
        int[][] dp = new int[N + 1][bag + 1];//行代表i物品 列代表还能放多少
        for (int index = N - 1; index >= 0; index--) {//从N-1号物品开始 依次往前
            for (int rest = 0; rest <= bag; rest++) {//每个物品要和不要比较
                // 内层循环中，递归函数怎么调，动态规划就怎么填，直接复制过来就行了
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if (rest - w[index] >= 0) {//如果还放得下的话
                    p2 = v[index] + dp[index + 1][rest - w[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 100;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dpWay(weights, values, bag));
    }

}
