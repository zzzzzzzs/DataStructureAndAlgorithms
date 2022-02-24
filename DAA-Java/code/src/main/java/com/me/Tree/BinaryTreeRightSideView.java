package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21 二叉树的右视图 https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 */
public class BinaryTreeRightSideView {

  // 层序遍历
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      int[] arr = new int[1];
      for (int i = 0; i < sz; i++) {
        TreeNode node = queue.poll();
        arr[0] = node.val;
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      list.add(arr[0]);
    }
    return list;
  }

  public void test() {
    Integer[] arr = {1, 2};
    TreeNode root = TreeNode.constructTree(arr);
    List<Integer> list = rightSideView(root);
    System.out.println(list);
  }

  public static void main(String[] args) {
    new BinaryTreeRightSideView().test();
  }

}
