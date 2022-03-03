package com.me.DoublePointer;

/**
 * 两数之和 II - 输入有序数组
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIiInputArrayIsSorted {

  // 有序就可以使用双指针
  public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target) {
        return new int[]{left + 1, right + 1};
      }else if(sum > target){
        right--;
      }else if(sum < target){
        left++;
      }
    }
    return new int[]{-1, -1};
  }

  void test() {
    int[] arr = {2,7,11,15};
    int[] ints = twoSum(arr, 9);
    System.out.println(ints);
  }

  public static void main(String[] args) {
    new TwoSumIiInputArrayIsSorted().test();
  }
}
