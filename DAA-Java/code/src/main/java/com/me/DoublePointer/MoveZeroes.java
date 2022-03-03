package com.me.DoublePointer;

/**
 * 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {

  public void moveZeroes(int[] nums) {
    if (nums.length < 2)
      return;
    int slow = 0, fast = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[fast] != 0) {
        int tmp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = tmp;
        slow++;
      }
      fast++;
    }
  }

  void test() {
    int[] arr = {0, 1, 0, 3, 12};
    moveZeroes(arr);
    System.out.println();
  }

  public static void main(String[] args) {
    new MoveZeroes().test();
  }
}
