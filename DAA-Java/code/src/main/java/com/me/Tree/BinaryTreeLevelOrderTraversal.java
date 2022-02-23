package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {


  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    // while 循环控制从上向下一层层遍历
    while (!q.isEmpty()) {
      int sz = q.size();
      // 记录这一层的节点值
      List<Integer> level = new LinkedList<>();
      // for 循环控制每一层从左向右遍历
      for (int i = 0; i < sz; i++) {
        TreeNode cur = q.poll();
        level.add(cur.val); // 业务
        if (cur.left != null)
          q.offer(cur.left);
        if (cur.right != null)
          q.offer(cur.right);
      }
      res.add(level);
    }
    return res;
  }

  public void test() {
    Integer[] arr = {3, 9, 20, null, null, 15, 7};
    TreeNode root = TreeNode.constructTree(arr);
    List<List<Integer>> list = levelOrder(root);
    System.out.println();
  }

  public static void main(String[] args) {
    new BinaryTreeLevelOrderTraversal().test();
  }

}
