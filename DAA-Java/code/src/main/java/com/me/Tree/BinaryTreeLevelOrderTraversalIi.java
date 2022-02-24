package com.me.Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/24 二叉树的层序遍历 II https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalIi {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> list = new LinkedList<>();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      List<Integer> level = new LinkedList<>();
      for (int i = 0; i < sz; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      list.addFirst(level);
    }
    return list;
  }

  public void test() {
    Integer[] arr = {};
    TreeNode root = TreeNode.constructTree(arr);
    List<List<Integer>> list = levelOrderBottom(root);
    System.out.println();
  }

  public static void main(String[] args) {
    new BinaryTreeLevelOrderTraversalIi().test();
  }

}
