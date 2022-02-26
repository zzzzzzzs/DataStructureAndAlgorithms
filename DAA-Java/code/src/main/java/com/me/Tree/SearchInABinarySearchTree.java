package com.me.Tree;

/**
 * 二叉搜索树中的搜索
 * 
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInABinarySearchTree {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null || root.val == val) {
      return root;
    }
    if (root.val > val)
      return searchBST(root.left, val);
    if (root.val < val)
      return searchBST(root.right, val);
    return null;
  }

  public void test() {
    Integer[] arr = {4, 2, 7, 1, 3};
    TreeNode root = TreeNode.constructTree(arr);
    TreeNode node = searchBST(root, 2);
    System.out.println(node);
  }

  public static void main(String[] args) {
    new SearchInABinarySearchTree().test();
  }
}
