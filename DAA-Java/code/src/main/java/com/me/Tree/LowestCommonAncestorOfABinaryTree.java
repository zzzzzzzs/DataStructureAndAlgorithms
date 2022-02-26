package com.me.Tree;

/**
 *
 * 二叉树的最近公共祖先
 * 
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 */
public class LowestCommonAncestorOfABinaryTree {

  // 自底向上，后序遍历
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    lowestCommonAncestor(root.left, p, q);
    lowestCommonAncestor(root.right, p, q);
    return null;
  }

  public void test() {
    Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
    TreeNode root = TreeNode.constructTree(arr);
    lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
    System.out.println();
  }

  public static void main(String[] args) {
    new LowestCommonAncestorOfABinaryTree().test();
  }

}
