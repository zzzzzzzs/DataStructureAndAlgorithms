package com.me.Tree;

/**
 *
 * 二叉搜索树中的插入操作
 *
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 *
 */
public class InsertIntoABinarySearchTree {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null)
      return new TreeNode(val);

    if (root.val > val)
      root.left = insertIntoBST(root.left, val);
    if (root.val < val)
      root.right = insertIntoBST(root.right, val);
    return root;
  }

  public void test() {
    Integer[] arr = {4, 2, 7, 1, 3};
    TreeNode root = TreeNode.constructTree(arr);
    insertIntoBST(root, 5);
    System.out.println();
  }

  public static void main(String[] args) {
    new InsertIntoABinarySearchTree().test();
  }

}
