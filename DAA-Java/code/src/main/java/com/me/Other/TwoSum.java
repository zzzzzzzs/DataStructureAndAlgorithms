package com.me.Other;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[] {i, map.get(target - nums[i])};
      }
      map.put(nums[i], i);
    }
    return new int[] {-1, -1};
  }

  void test() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] indexs = twoSum(nums, target);
    System.out.println();
  }

  public static void main(String[] args) {
    new TwoSum().test();
  }
}
