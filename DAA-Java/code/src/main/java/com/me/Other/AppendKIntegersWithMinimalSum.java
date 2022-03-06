package com.me.Other;

import java.util.HashSet;
import java.util.Set;

/**
 * 向数组中追加 K 个整数
 *
 * https://leetcode-cn.com/contest/weekly-contest-283/problems/append-k-integers-with-minimal-sum/
 */
public class AppendKIntegersWithMinimalSum {
  public long minimalKSum(int[] nums, int k) {
    Set<Long> set =new HashSet<>();
    for (int num : nums) {
      set.add((long)num);
    }
    long sum = 0;
    for (long i = 1;; i++) {
      if (!set.contains(i)) {
        sum += i;
        k--;
        if (k == 0) {
          break;
        }
      }
    }
    return sum;
  }

  void test() {
    int[] arr = {5, 6};
    long l = minimalKSum(arr, 6);
    System.out.println(l);
  }

  public static void main(String[] args) {
    new AppendKIntegersWithMinimalSum().test();
  }
}
