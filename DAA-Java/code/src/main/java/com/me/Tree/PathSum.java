package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/22 路径总和 https://leetcode-cn.com/problems/path-sum/
 */
public class PathSum {

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

  int num = 0;
  boolean flag = false;
  public boolean hasPathSum(TreeNode root, int targetSum) {
    process(root, targetSum);
    return flag;
  }

  // dfs
  void process(TreeNode root, int targetSum) {
    if (root == null ) {
      if(num == targetSum){
        flag = true;
      }
      return;
    }
    num += root.val;
    process(root.left, targetSum);
    process(root.right, targetSum);
    num -= root.val;
  }

  void test() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(4);
    boolean b = hasPathSum(root, 22);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new PathSum().test();
  }
}
