package com.me.DoublePointer;

/**
 * 移除元素
 *
 * https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

  // 有序就可以使用双指针
  public int removeElement(int[] nums, int val) {
    int slow = 0, fast = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }

  void test() {
    int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
    int i = removeElement(arr, 2);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new RemoveElement().test();
  }
}
