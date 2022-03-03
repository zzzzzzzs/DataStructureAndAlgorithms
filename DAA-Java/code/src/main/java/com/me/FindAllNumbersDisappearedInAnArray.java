package com.me;

import java.util.*;

/**
 * 找到所有数组中消失的数字
 *
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInAnArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 1; i <= nums.length; i++) {
      if (!set.contains(i)) {
        res.add(i);
      }
    }
    return res;
  }

  public void test() {
    int[] nums = {4,3,2,7,8,2,3,1};
    List<Integer> list = findDisappearedNumbers(nums);
    System.out.println(list);
  }

  public static void main(String[] args) {
    new FindAllNumbersDisappearedInAnArray().test();
  }
}
