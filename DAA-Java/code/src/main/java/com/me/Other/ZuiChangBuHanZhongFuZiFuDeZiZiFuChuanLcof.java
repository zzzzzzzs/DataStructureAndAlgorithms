package com.me.Other;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串
 *
 * <p>https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
  public int lengthOfLongestSubstring(String s) {
    int len = 0;
    char[] chars = s.toCharArray();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < chars.length; i++) {
      set.add(chars[i]);
      len = Math.max(len, set.size());
      for (int j = i + 1; j < chars.length; j++) {
        if (!set.contains(chars[j])) {
          set.add(chars[j]);
          len = Math.max(len, set.size());
        } else {
          set.clear();
          break;
        }
      }
    }
    return len;
  }

  void test() {
    String ss = "pwwkew";
    int i = lengthOfLongestSubstring(ss);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().test();
  }
}
