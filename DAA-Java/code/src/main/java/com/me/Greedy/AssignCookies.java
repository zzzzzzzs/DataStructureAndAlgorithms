package com.me.Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.me.Tree.TreeNode;

/**
 * 分发饼干
 *
 * https://leetcode-cn.com/problems/assign-cookies/
 */
public class AssignCookies {

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int index = 0;
    for (int i = 0; i < s.length; i++) {
      if (index < g.length && g[index] <= s[i]) { // 小饼干分配给胃口小的
        index++;
      }
    }
    return index;
  }

  public void test() {
    int[] g = {10, 9, 8, 7, 10, 9, 8, 7};
    int[] s = {10, 9, 8, 7};
    int i = findContentChildren(g, s);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new AssignCookies().test();
  }

}
