package com.me.Other;

/***
 * 6027. 统计数组中峰和谷的数量 adsa
 */
public class CountHillsAndValleysInAnArray {

  public int countHillValley(int[] nums) {
    if (nums == null || nums.length < 3) {
      return -1; // no exist
    }
    int num = 0;
    for (int i = 1; i < nums.length - 1; i++) {
      // 波谷 || 波峰
      if ((nums[i] <= nums[i - 1] && nums[i] <= nums[i + 1])
          || (nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1])) {
        num++;
      }
    }
    return num;
  }

  void test() {
    int[] nums = {2, 4, 1, 1, 6, 5};
    int num = countHillValley(nums);
    System.out.println(num);
  }

  public static void main(String[] args) {
    new CountHillsAndValleysInAnArray().test();
  }
}
