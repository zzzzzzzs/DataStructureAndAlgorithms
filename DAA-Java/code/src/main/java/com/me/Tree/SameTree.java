package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/21 相同的树 https://leetcode-cn.com/problems/same-tree/
 */
public class SameTree {


  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public void test() {
    Integer[] arr1 = {};
    Integer[] arr2 = {0};
    TreeNode root1 = TreeNode.constructTree(arr1);
    TreeNode root2 = TreeNode.constructTree(arr2);
    boolean b = isSameTree(root1, root2);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new SameTree().test();
  }
}
