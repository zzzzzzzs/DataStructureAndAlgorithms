package com.me.SlidingWindow;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    int left = 0;
    int right = 0;
    int bestResult = 0;
    HashMap<Character, Integer> window = new HashMap<>();

    while (right < s.length()) {
      char result = s.charAt(right);// 取出单独的字符
      right++;
      // 将当前的字符加入到window中
      window.put(result, window.getOrDefault(result, 0) + 1);
      // 如果当前的字符在window中个数大于1了 就是有重复了
      while (window.get(result) > 1) {
        char d = s.charAt(left);
        window.put(d, window.get(d) - 1);// 更新移除的字符的个数
        left++;// left右移
      }
      bestResult = Math.max(bestResult, right - left);
    }
    return bestResult;
  }

  void test() {
    int i = lengthOfLongestSubstring("dvvf");
    System.out.println(i);
  }

  public static void main(String[] args) {
    new LongestSubstringWithoutRepeatingCharacters().test();
  }
}
