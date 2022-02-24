package com.me.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21
 */
public class MaximumDepthOfBinaryTree {

  int res = 0;
  int depth = 0;

  public int maxDepth(TreeNode root) {
    process1(root);
    return res;
  }

  // 宽度优先遍历
  void process1(TreeNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      res++;
      for (int i = 0; i < sz; i++) {
        TreeNode node = queue.poll();
        if (node.left != null)
          queue.offer(node.left);
        if (node.right != null)
          queue.offer(node.right);
      }
    }
  }

  // 深度优先遍历
  public void process(TreeNode root) {
    if (root == null) {
      res = Math.max(res, depth);
      return;
    }
    depth++;
    process(root.left);
    process(root.right);
    depth--;
  }

  public void test() {
    Integer[] arr = {3, 9, 20, null, null, 15, 7};
    TreeNode root = TreeNode.constructTree(arr);
    int i = maxDepth(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new MaximumDepthOfBinaryTree().test();
  }

}
