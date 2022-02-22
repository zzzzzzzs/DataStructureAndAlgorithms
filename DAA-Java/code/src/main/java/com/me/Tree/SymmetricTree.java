package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/22 对称二叉树 https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {
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

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return process(root.left, root.right);
  }
  // bfs
  boolean process(TreeNode l, TreeNode r) {
    if (l == null || r == null) {
      return l == r;
    }
    if (l.val != r.val) {
      return false;
    }
    // 遍历左树的左节点,遍历右树的右节点 && 遍历左树的右节点,遍历右树的左节点
    return process(l.left, r.right) && process(l.right, r.left);
  }

  void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    // root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(3);
    // root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    boolean b = isSymmetric(root);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new SymmetricTree().test();
  }
}
