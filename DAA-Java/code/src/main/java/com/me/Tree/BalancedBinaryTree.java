package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/22 平衡二叉树 https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
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

  boolean flag = true;

  public boolean isBalanced(TreeNode root) {
    process(root);
    return flag;
  }

  int process(TreeNode root) {
    if (root == null || flag == false) {
      return 0;
    }
    int leftDepth = process(root.left);
    int rightDepth = process(root.right);
    if (Math.abs(leftDepth - rightDepth) > 1) {
      flag = false;
    }
    return 1 + Math.max(leftDepth, rightDepth);
  }

  void test() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    boolean b = isBalanced(root);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new BalancedBinaryTree().test();
  }
}
