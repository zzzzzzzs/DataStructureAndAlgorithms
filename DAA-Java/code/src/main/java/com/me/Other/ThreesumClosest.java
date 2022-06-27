package com.me.Other;

import java.util.*;

/**
 * 最接近的三数之和
 *
 * <p>https://leetcode-cn.com/problems/3sum-closest/
 */
public class ThreesumClosest {
  int distance(int a, int b) {
    return Math.abs(a - b);
  }

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int min = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length; i++) {
      int left =  i + 1, right = nums.length-1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (distance(sum, target) < distance(min, target)) {
          min = sum;
        }
        if(sum > target) right--;
        else if(sum < target) left++;
        else return target;
      }
    }
    return min;
  }

  void test() {
    int[] nums = {1, 1, 1, 1};
    int i = threeSumClosest(nums, 0);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new ThreesumClosest().test();
  }
}
