package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21
 *
 *       找树左下角的值
 * 
 *       https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 *
 */
public class FindBottomLeftTreeValue {

  // 层序遍历
  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int num = 0;
    while (!queue.isEmpty()) {
      int sz = queue.size();
      LinkedList<TreeNode> list = new LinkedList<>();
      for (int i = 0; i < sz; i++) {
        TreeNode node = queue.poll();
        list.add(node);
        if(node.left != null) queue.offer(node.left);
        if(node.right != null) queue.offer(node.right);
      }
      num = list.getFirst().val;
    }
    return num;
  }

  public void test() {
    Integer[] arr = {2, 1, 3};
    TreeNode root = TreeNode.constructTree(arr);
    int i = findBottomLeftValue(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new FindBottomLeftTreeValue().test();
  }

}
