package com.me.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 * 
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

  LinkedList<List<String>> res = new LinkedList<>();
  LinkedList<String> path = new LinkedList<>();

  public List<List<String>> partition(String s) {
    // backStrack();
    return null;
  }

  void backStrack(String s, int startIndex) {
    //
    // if(){
    // res.add(new LinkedList<>(path));
    // }

    for (int i = startIndex; i < s.length(); i++) {
      backStrack(s, i + 1);

    }
  }

  void test() {
    List<List<String>> combine = partition("aab");
    System.out.println(combine);
  }

  public static void main(String[] args) {
    new PalindromePartitioning().test();
  }
}
