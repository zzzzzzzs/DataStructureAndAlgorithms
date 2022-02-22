package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/22 翻转二叉树 https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
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

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  void test() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    // root.left.left = new TreeNode(1);
    // root.left.right = new TreeNode(3);
    // root.right.left = new TreeNode(6);
    // root.right.right = new TreeNode(9);
    TreeNode treeNode = invertTree(root);
    System.out.println();
  }

  public static void main(String[] args) {
    new InvertBinaryTree().test();
  }
}
