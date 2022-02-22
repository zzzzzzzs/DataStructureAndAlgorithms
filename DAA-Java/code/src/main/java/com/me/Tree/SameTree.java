package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/21 相同的树 https://leetcode-cn.com/problems/same-tree/
 */
public class SameTree {
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

  // TODO ??? leetcode 有问题吧
  public boolean isSameTree(TreeNode p, TreeNode q) {
    process(p, q);
    return flag;
  }

  public void process(TreeNode p, TreeNode q) {
    if (p == null || q == null || flag == false) {
      return;
    }
    if (p.val != q.val) {
      flag = false;
      return;
    }
    // 在不等于null的基础上不相等
    if ((p.left == null) != (q.left == null)) {
      flag = false;
      return;
    }
    if ((p.right == null) != (q.right == null)) {
      flag = false;
      return;
    }
    process(p.left, q.left);
    process(p.right, q.right);
  }

  public void test() {
    TreeNode root1 = new TreeNode();
    TreeNode root2 = new TreeNode(0);
    boolean b = isSameTree(root1, root2);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new SameTree().test();
  }
}
