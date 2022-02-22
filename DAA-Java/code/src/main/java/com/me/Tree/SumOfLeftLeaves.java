package com.me.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zs
 * @date 2022/2/22 左叶子之和 https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  int sum = 0;

  public int sumOfLeftLeaves(TreeNode root) {
    process(root, false);
    return sum;
  }

  void process(TreeNode root, boolean flag) {
    if (root == null) {
      return;
    }
    // 叶子节点
    if (root.left == null && root.right == null && flag == true) {
      sum += root.val;
      return;
    }
    process(root.left, true);
    process(root.right, false);
  }

  public void test() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    int i = sumOfLeftLeaves(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new SumOfLeftLeaves().test();
  }
}
