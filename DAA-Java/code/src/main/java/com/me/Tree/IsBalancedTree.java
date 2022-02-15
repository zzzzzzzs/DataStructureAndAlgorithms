package com.me.Tree;

import javax.swing.*;
import java.util.Date;

/**
 * @author zs
 * @date 2021/10/19. 二叉树的递归套路:1.判断二叉树是不是平衡二叉树
 */
public class IsBalancedTree {
  public static class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
      this.value = data;
    }
  }

  public static boolean isBalanced(Node head) {
    return process(head).isBalanced;
  }

  /**
   * 使用自定义类存储节点是否为二叉树和子树的高度.
   */
  private static Info process(Node x) {
    if (x == null) {
      // 空树好设置
      return new Info(0, true);
    }

    Info left = process(x.left);
    Info right = process(x.right);

    // 左树平衡 && 右树平衡 && 左树和右树高度差不超过1
    boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;
    int height = Math.max(left.height, right.height) + 1;
    return new Info(height, isBalanced);
  }

  public static class Info {
    int height;
    boolean isBalanced;

    public Info(int h, boolean b) {
      height = h;
      isBalanced = b;
    }
  }

  /**
   * 对数器
   */
  public static boolean isBalancedUseArray(Node head) {
    if (head == null)
      return true;
    boolean[] ans = new boolean[1];
    ans[0] = true;
    process(head, ans);
    return ans[0];
  }

  /**
   * boolean基础类型是按值传递, 所以使用数组封装. 存储节点是否为二叉树. 返回子树高度.
   */
  private static int process(Node x, boolean[] ans) {
    if (!ans[0] || x == null)
      return -1;

    int leftH = process(x.left, ans);
    int rightH = process(x.right, ans);
    if (Math.abs(leftH - rightH) > 1) {
      ans[0] = false;
    }

    return Math.max(leftH, rightH) + 1;
  }

  public static void main(String[] args) {
    int maxLevel = 6;
    int maxValue = 100;
    int testTimes = 100000;
    System.out.println("start test");
    for (int i = 0; i < testTimes; i++) {
      // Node head = TreeTestHelper.generateRandomBTS(maxLevel, maxValue);
      // if (isBalanced(head) != isBalancedUseArray(head)) {
      // System.out.println("error");
      // break;
      // }
    }
    System.out.println("finished");
  }
}
