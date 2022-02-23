package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21 二叉树的层平均值 https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree {

  // 层序遍历
  public List<Double> averageOfLevels(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<Double> avers = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int sz = q.size();
      long sum = 0;
      for (int i = 0; i < sz; i++) {
        TreeNode cur = q.poll();
        sum += cur.val;
        if (cur.left != null) {
          q.offer(cur.left);
        }
        if (cur.right != null) {
          q.offer(cur.right);
        }
      }
      avers.add((double)sum / sz);
    }
    return avers;
  }

  public void test() {
    Integer[] arr = {2147483647, 2147483647, 2147483647};
    TreeNode root = TreeNode.constructTree(arr);
    List<Double> list = averageOfLevels(root);
    System.out.println(list);
  }

  public static void main(String[] args) {
    new AverageOfLevelsInBinaryTree().test();
  }

}
