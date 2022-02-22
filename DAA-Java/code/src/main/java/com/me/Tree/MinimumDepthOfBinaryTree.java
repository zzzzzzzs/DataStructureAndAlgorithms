package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/21 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
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

  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    if(root.left == null) return 1 + minDepth(root.right); // 左树为空
    if(root.right == null) return 1 + minDepth(root.left); // 右树为空
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }

  public void test() {
    TreeNode root = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(5);
    root.right.right.right.right = new TreeNode(6);
    int i = minDepth(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new MinimumDepthOfBinaryTree().test();
  }

}
