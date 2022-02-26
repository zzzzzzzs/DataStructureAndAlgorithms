package com.me.Backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 * 
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumIi {

  LinkedList<List<Integer>> res = new LinkedList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates); // 使相同元素在一起
    backStrack(candidates, target, 0, 0);
    return res;
  }

  void backStrack(int[] candidates, int target, int startIndex, int sum) {
    if (sum > target) {
      return;
    }
    if (target == sum) {
      res.add(new LinkedList<>(path));
      return;
    }
    for (int i = startIndex; i < candidates.length; i++) {
      // 要对同一树层使用过的元素进行跳过
      // i > startIndex 为了防止数组越界
      if (i > startIndex && candidates[i] == candidates[i - 1]) {
        continue;
      }
      sum += candidates[i];
      path.add(candidates[i]);
      backStrack(candidates, target, i + 1, sum);
      path.removeLast();
      sum -= candidates[i];
    }
  }

  void test() {
    int[] arr = {10, 1, 2, 7, 6, 1, 5};
    List<List<Integer>> combine = combinationSum2(arr, 8);
    System.out.println(combine);
  }

  public static void main(String[] args) {
    new CombinationSumIi().test();
  }
}
