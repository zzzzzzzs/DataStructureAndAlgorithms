package com.me.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zs
 * @date 2024/5/19
 * 不同路径
 * https://leetcode.cn/problems/unique-paths/description/
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        Map<String, Integer> cache = new HashMap<>();
//        return dfs(0, 0, m, n);
        return dfs1(0, 0, m, n, cache);
    }

    public static int dfs(int i, int j, int m, int n) {
        if (i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }

    public static int dfs1(int i, int j, int m, int n, Map<String, Integer> cache) {
        String key = i + "|" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        int res = dfs1(i + 1, j, m, n, cache) + dfs1(i, j + 1, m, n, cache);
        cache.put(key, res);
        return res;
    }



    public static void main(String[] args) {
        System.out.println(uniquePaths(19, 13));
    }
}
