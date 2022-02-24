package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/21 二叉树展开为链表 https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;
    root.right = left;

    TreeNode p = root;
    // 来到最后一个节点
    while (p.right != null) {
      p = p.right;
    }
    p.right = right;
  }

  public void test() {
    Integer[] arr = {1, 2, 5};
    TreeNode root = TreeNode.constructTree(arr);
    flatten(root);
    System.out.println();
  }

  public static void main(String[] args) {
    new FlattenBinaryTreeToLinkedList().test();
  }

}
