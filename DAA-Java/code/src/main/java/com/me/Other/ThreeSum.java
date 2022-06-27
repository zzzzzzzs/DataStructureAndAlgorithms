package com.me.Other;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 三数之和
 *
 * <p>https://leetcode-cn.com/problems/two-sum/
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    Set<String> set = new HashSet();
    Arrays.sort(nums); // 为了二分查找
    // 双指针
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        int target = 0 - nums[i] - nums[j];
        int k = Arrays.binarySearch(nums, j + 1, nums.length, target);
        if (k < 0) {
          continue;
        }
        String s = nums[i] + "" + nums[j] + "" + nums[k];
        // 去重
        if (!set.contains(s)) {
          set.add(s);
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
        }
      }
    }
    return result;
  }

  void test() {
    int[] nums = {0,0,0};
    List<List<Integer>> lists = threeSum(nums);
    System.out.println(lists);
  }

  public static void main(String[] args) {
    new ThreeSum().test();
  }
}
