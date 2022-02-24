package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21
 *
 *       从中序与后序遍历序列构造二叉树
 * 
 *       https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    TreeNode node = new TreeNode(postorder[postorder.length - 1]);
    for (int i = 0; i < postorder.length - 1; i++) {

    }
    return null;
  }

  public void test() {
    int[] arr1 = {9, 3, 15, 20, 7};
    int[] arr2 = {9, 15, 7, 20, 3};

    TreeNode node = buildTree(arr1, arr2);
    System.out.println(node);
  }

  public static void main(String[] args) {
    new ConstructBinaryTreeFromInorderAndPostorderTraversal().test();
  }

}
