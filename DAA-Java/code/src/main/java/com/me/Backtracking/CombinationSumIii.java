package com.me.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 III
 * 
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class CombinationSumIii {

  LinkedList<List<Integer>> res = new LinkedList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum3(int k, int n) {
    backStrack(k, n, 1, 0);
    return res;
  }

  void backStrack(int k, int n, int startIndex, int sum) {
    if (path.size() == k) {
      if (sum == n) {
        res.add(new LinkedList<>(path));
      }
      return;
    }

    for (int i = startIndex; i <= 9; i++) {
      sum += i;
      path.add(i);
      backStrack(k, n, i + 1, sum);
      path.removeLast();
      sum -= i;
    }
  }

  void test() {
    List<List<Integer>> combine = combinationSum3(3, 7);
    System.out.println(combine);
  }

  public static void main(String[] args) {
    new CombinationSumIii().test();
  }
}
