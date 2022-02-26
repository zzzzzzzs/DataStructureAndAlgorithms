package com.me.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

  LinkedList<String> res = new LinkedList<>();

  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return res;
    }
    backStrack(digits, 0);
    return res;
  }
  // 初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
  String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  StringBuilder sb = new StringBuilder();

  void backStrack(String digits, int num) {
    if (digits.length() == num) {
      res.add(sb.toString());
      return;
    }
    String str = map[digits.charAt(num) - '0'];
    for (int i = 0; i < str.length(); i++) {
      sb.append(str.charAt(i));
      backStrack(digits, num + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  void test() {
    List<String> list = letterCombinations("23");
    System.out.println(list);
  }

  public static void main(String[] args) {
    new LetterCombinationsOfAPhoneNumber().test();
  }
}
