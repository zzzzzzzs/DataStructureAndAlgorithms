package com.me.Greedy;

/**
 * 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 *
 */
public class JumpGameIi {

  // 在可以跳跃的范围内找最大的，然后判断是否可以达到最大的长度
  // TODO : 不会
  public int jump(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }

    int jumpNum = 1;

    int cur = 0; // 当前位置
    int step = nums[cur]; // 从当前位置要走多少步
    int maxStep = step; // 记录最大值
    int maxIndex = cur;
    for (int i = cur; i < step; i++) {
      // 选出走过的最大值，同时记录位置
      if (maxStep < nums[i]) {
        maxStep = nums[i];
        maxIndex = i;
      }
      if (nums[cur] < maxStep) {
        jumpNum++;
      }
      step = maxStep;
      cur = maxIndex;
      if (cur + maxStep > nums.length) {
        break;
      }
    }
    return jumpNum;
  }

  public void test() {
    int[] nums = {1, 2, 3};
    int i = jump(nums);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new JumpGameIi().test();
  }

}
