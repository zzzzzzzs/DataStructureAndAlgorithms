package com.me.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * 
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {

  LinkedList<List<Integer>> res = new LinkedList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combine(int n, int k) {
    backtrack(n, k, 1);
    return res;
  }

  void backtrack(int n, int k, int startIndex) {
    if (path.size() == k) {
      res.add(new LinkedList<>(path));
      return;
    }
    // for (int i = startIndex; i <= n; i++) {
    for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {// 剪枝优化
      path.add(i);
      backtrack(n, k, i + 1);
      path.removeLast();
    }
  }

  void test() {
    List<List<Integer>> combine = combine(4, 2);
    System.out.println(combine);
  }

  public static void main(String[] args) {
    new Combinations().test();
  }
}
