package com.me.Greedy;

/**
 * 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {

  // 在可以跳跃的范围内找最大的，然后判断是否可以达到最大的长度
  public boolean canJump(int[] nums) {
    int step = 0;
    if (nums.length == 1) {
      return true;
    }
    for (int i = 0; i <= step; i++) {
      step = Math.max(step, nums[i] + i);
      if (step >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }

  public void test() {
    int[] nums = {2, 0, 0};
    boolean b = canJump(nums);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new JumpGame().test();
  }

}
