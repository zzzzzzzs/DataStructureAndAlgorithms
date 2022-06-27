package com.me.Other;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算字符串的数字和
 *
 * <p>https://leetcode-cn.com/problems/calculate-digit-sum-of-a-string/
 */
public class CalculateDigitSumOfAString {
  public String digitSum(String s, int k) {
    if (s.length() <= 3) {
      return s;
    }
    String tmp = "";
    for (int i = 0; i < s.length(); i = i + 3) {
      String sub;
      if (i + 3 > s.length()) {
        sub = s.substring(i);
      } else {
        sub = s.substring(i, i + 3);
      }
      int sum = 0;
      for (int j = 0; j < sub.length(); j++) {
        sum += sub.charAt(j) - '0';
      }
      tmp += sum + "";
    }
    return digitSum(tmp, k);
  }

  void test() {
    String ss = "00000000";
    String s = digitSum(ss, 3);
    System.out.println(s);
  }

  public static void main(String[] args) {
    new CalculateDigitSumOfAString().test();
  }
}
