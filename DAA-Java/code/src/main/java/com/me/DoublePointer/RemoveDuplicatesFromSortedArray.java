package com.me.DoublePointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除有序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

  // 有序就可以使用双指针
  public int removeDuplicates(int[] nums) {
    int slow = 0, fast = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[slow] != nums[fast]) {
        slow++;
        nums[slow] = nums[fast];
      }
      fast++;
    }
    return slow+1;
  }

  void test() {
    int[] arr = {1, 1, 2};
    int i = removeDuplicates(arr);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new RemoveDuplicatesFromSortedArray().test();
  }
}
