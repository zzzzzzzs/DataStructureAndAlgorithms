package com.me.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zs
 * @date 2021/10/25 打印一个字符串的全部子序列，包括空字符串
 */
public class PrintAllSubsquences {

  public static void printAllSub(char[] str, int i, String res) {
    if (i == str.length) {
      System.out.println(res);
      return;
    }
    // 两种情况
    printAllSub(str, i + 1, res + str[i]); // 要当前的字符
    printAllSub(str, i + 1, res); // 不要当前的字符
  }

  public static List<String> getAllSubs(String s) {
    char[] str = s.toCharArray();
    String path = "";
    List<String> ans = new ArrayList<>();
    process(str, 0, ans, path);
    return ans;
  }

  public static void process(char[] str, int index, List<String> ans, String path) {
    if (index == str.length) {
      ans.add(path);
      return;
    }
    String noPath = path;
    process(str, index + 1, ans, noPath);
    String yesPath = path + String.valueOf(str[index]);
    process(str, index + 1, ans, yesPath);
  }

  public static void main(String[] args) {
    String test = "abc";
    List<String> ans = getAllSubs(test);

    for (String str : ans) {
      System.out.println(str);
    }
    System.out.println("----------------");
    printAllSub(test.toCharArray(), 0, "");
  }
}
