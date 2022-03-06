package com.me.SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 找到字符串中所有字母异位词
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {

  public List<Integer> findAnagrams(String s, String p) {
    return null;
  }

  void test() {
    List<Integer> list = findAnagrams("cbaebabacd", "abc");
    System.out.println(list);
  }

  public static void main(String[] args) {
    new FindAllAnagramsInAString().test();
  }
}
