package com.me.Greedy;

/**
 * 摆动序列
 *
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 */
public class WiggleSubsequence {

  public int wiggleMaxLength(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }

    int up = 1;
    int down = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] > 0) {
        up = down + 1;
      }
      if (nums[i] - nums[i - 1] < 0) {
        down = up + 1;
      }
    }
    return Math.max(up, down);
  }

  public void test() {
    int[] nums = {3, 3, 3, 2, 5};
    int i = wiggleMaxLength(nums);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new WiggleSubsequence().test();
  }
}
