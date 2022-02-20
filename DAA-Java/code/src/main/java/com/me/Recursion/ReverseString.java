package com.me.Recursion;

/**
 * @author zs
 * @date 2022/2/20 反转字符串 https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseString {

  public static void swap(char[] a, int i, int j) {
    char temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public void reverseString(char[] s) {
    for (int i = 0; i < s.length / 2; i++) {
      swap(s, i, s.length - i - 1);
    }
  }

  public void test() {
    String s = "Hello";
    char[] arr = s.toCharArray();
    reverseString(arr);
    for (char c : arr) {
      System.out.print(c);
    }
  }

  public static void main(String[] args) {
    new ReverseString().test();
  }
}
