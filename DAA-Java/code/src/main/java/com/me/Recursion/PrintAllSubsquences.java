package com.me.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zs
 * @date 2021/10/25 打印一个字符串的全部子序列，包括空字符串
 */
public class PrintAllSubsquences {
  public static void printAllSubsquence(String str) {
    char[] chs = str.toCharArray();
    process(chs, 0);
  }

  // 当前来到i位置，要和不要，走两条路
  // 之前的选择，所形成的结果，是str
  public static void process(char[] str, int i) {
    // 中止条件就是来到的字符位置等于字符串的长度
    if (i == str.length) {
      System.out.println(String.valueOf(str));
      return;
    }
    process(str, i + 1); // 要当前字符的路
    char tmp = str[i];
    str[i] = 0; // 将不要的字符置为0
    process(str, i + 1); // 不要当前字符的路
    str[i] = tmp; // 将字符复原
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
    printAllSubsquence(test);
  }
}
