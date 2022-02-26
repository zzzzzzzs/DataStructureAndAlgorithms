package com.me.Tree;

/**
 * 二叉搜索树的最近公共祖先
 * 
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 */
public class LowestCommonAncestorOfABinarySearchTree {

  // 自底向上，后序遍历
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    return null;
  }

  public void test() {
    Integer[] arr = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
    TreeNode root = TreeNode.constructTree(arr);
    lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
    System.out.println();
  }

  public static void main(String[] args) {
    new LowestCommonAncestorOfABinarySearchTree().test();
  }
}
