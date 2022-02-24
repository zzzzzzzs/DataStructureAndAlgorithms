package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/21 单值二叉树 https://leetcode-cn.com/problems/univalued-binary-tree/
 */
public class UnivaluedBinaryTree {

  boolean flag = true;
  int value = 0;

  public boolean isUnivalTree(TreeNode root) {
    value = root.val;
    process(root);
    return flag;
  }

  void process(TreeNode root) {
    if (root == null || flag == false) {
      return;
    }
    if (value != root.val) {
      flag = false;
    }
    System.out.println(root.val);
    process(root.left);
    process(root.right);
  }

  public void test() {
    Integer[] arr = {1, 1, 1, 1, 1, null, 1};
    TreeNode root = TreeNode.constructTree(arr);
    boolean b = isUnivalTree(root);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new UnivaluedBinaryTree().test();
  }

}
