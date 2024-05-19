package com.me.DP;

import java.util.*;

/**
 * @author zs
 * @date 2024/5/19
 * 最小路径和 TODO 不懂
 * https://leetcode.cn/problems/minimum-path-sum/
 *
 * 参考
 * https://blog.csdn.net/sinat_42483341/article/details/111026178
 *
 * https://zhuanlan.zhihu.com/p/53871245
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int M = grid.length - 1;
        int N = grid[0].length - 1;
        return dfs(0, 0, 0,M, N, grid);
    }

    public static int dfs(int i, int j, int cur, int M, int N, int[][] grid) {
        cur += grid[i][j];
        if (i == M && j == N) {
            return cur;
        }
        if (i >= M) {
            return dfs(i, j + 1, cur,M, N, grid);
        } else if (j >= N) {
            return dfs(i + 1, j, cur,M, N, grid);
        }

        return Math.min(dfs(i + 1, j, cur,M, N, grid), dfs(i, j + 1, cur, M, N, grid));
    }



    public static void main(String[] args) {
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = {{1,2},{3, 4}};
        System.out.println(minPathSum(grid));
    }
}
