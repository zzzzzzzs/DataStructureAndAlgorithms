package com.me.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 * 
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {

  LinkedList<List<Integer>> res = new LinkedList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    backStrack(candidates, target, 0, 0);
    return res;
  }

  void backStrack(int[] candidates, int target, int startIndex, int sum) {
    if (res.size() >= 150 || sum > target) {
      return;
    }
    if (target == sum) {
      res.add(new LinkedList<>(path));
      return;
    }
    for (int i = startIndex; i < candidates.length; i++) {
      sum += candidates[i];
      path.add(candidates[i]);
      backStrack(candidates, target, i, sum);
      path.removeLast();
      sum -= candidates[i];
    }
  }

  void test() {
    int[] arr = {2, 3, 6, 7};
    List<List<Integer>> combine = combinationSum(arr, 7);
    System.out.println(combine);
  }

  public static void main(String[] args) {
    new CombinationSum().test();
  }
}
