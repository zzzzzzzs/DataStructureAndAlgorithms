package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21
 *
 *       完全二叉树的节点个数
 *
 *       https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  public void test() {
    Integer[] arr = {1, 2, 3, 4, 5, 6};
    TreeNode root = TreeNode.constructTree(arr);
    int i = countNodes(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new CountCompleteTreeNodes().test();
  }

}
