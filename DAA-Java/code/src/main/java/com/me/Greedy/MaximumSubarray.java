package com.me.Greedy;

/**
 * 最大子数组和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {


  // 贪心写法
  public int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int sum = Integer.MIN_VALUE;
    int tmp = 0;
    for (int i = 0; i < nums.length; i++) {
      tmp = 0;
      for (int j = i; j < nums.length; j++) {
        tmp += nums[j];
        sum = Math.max(sum, tmp);
        if (tmp <= 0)
          tmp = 0;
      }
    }
    return sum;
  }

  public void test() {
    int[] nums = {-2, -1};
    int i = maxSubArray(nums);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new MaximumSubarray().test();
  }
}
