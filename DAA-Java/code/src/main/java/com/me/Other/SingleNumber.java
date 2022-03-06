package com.me.Other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 只出现一次的数字
 *
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {
  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums){
      if(set.contains(num)){
        set.remove(num);
        continue;
      }
      set.add(num);
    }
    return (int)set.toArray()[0];
  }

  void test() {
    int[] nums = {2, 2, 1};
    int i = singleNumber(nums);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new SingleNumber().test();
  }
}
