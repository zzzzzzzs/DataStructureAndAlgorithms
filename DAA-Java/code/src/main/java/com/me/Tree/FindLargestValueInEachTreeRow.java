package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21
 *
 *       在每个树行中找最大值
 * 
 *       https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 */
public class FindLargestValueInEachTreeRow {

  // 层序遍历
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    if (root == null)
      return list;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      int num = Integer.MIN_VALUE;
      for (int i = 0; i < sz; i++) {
        TreeNode node = queue.poll();
        num = Math.max(num, node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      list.add(num);
    }
    return list;
  }

  public void test() {
    Integer[] arr = {1, 3, 2, 5, 3, null, 9};
    TreeNode root = TreeNode.constructTree(arr);
    List<Integer> list = largestValues(root);
    System.out.println(list);
  }

  public static void main(String[] args) {
    new FindLargestValueInEachTreeRow().test();
  }

}
