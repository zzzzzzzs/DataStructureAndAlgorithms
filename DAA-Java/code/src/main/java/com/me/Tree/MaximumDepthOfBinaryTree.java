package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/21
 */
public class MaximumDepthOfBinaryTree {

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

  int res = 0;
  int depth = 0;

  public int maxDepth(TreeNode root) {
    process(root);
    return res;
  }

  public void process(TreeNode root) {
    if (root == null) {
      res = Math.max(res, depth);
      return;
    }
    depth++;
    process(root.left);
    process(root.right);
    depth--;
  }

  public void test() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    int i = maxDepth(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new MaximumDepthOfBinaryTree().test();
  }

}
