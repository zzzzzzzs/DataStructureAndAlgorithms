package com.me.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
  public int minDepth(TreeNode root) {
    int minDepth = 0;
    if (root == null) {
      return minDepth;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      minDepth++;
      for (int i = 0; i < sz; i++) {
        TreeNode node = queue.poll();
        if (node.left != null)
          queue.offer(node.left);
        if (node.right != null)
          queue.offer(node.right);
        // 叶子节点
        if (node.left == null && node.right == null) {
          return minDepth;
        }
      }
    }
    return 0;
  }

  public int minDepth1(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left == null)
      return 1 + minDepth(root.right); // 左树为空
    if (root.right == null)
      return 1 + minDepth(root.left); // 右树为空
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }

  public void test() {
    Integer[] arr = {1, 2, null, 3, null, 4, null, 5};
    TreeNode root = TreeNode.constructTree(arr);
    int i = minDepth(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new MinimumDepthOfBinaryTree().test();
  }

}
