package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21 从根到叶的二进制数之和 https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumOfRootToLeafBinaryNumbers {

  int res = 0;
  int path = 0;

  public int sumRootToLeaf(TreeNode root) {
    process(root);
    return res;
  }

  void process(TreeNode root) {
    if (root == null) {
      return;
    }
    // 叶子节点
    if (root.left == null && root.right == null) {
      res += path << 1 | root.val;
      return;
    }
    path = path << 1 | root.val;
    process(root.left);
    process(root.right);
    path = path >> 1;
  }

  public void test() {
    Integer[] arr = {1, 0, 1, 0, 1, 0, 1};
    TreeNode root = TreeNode.constructTree(arr);
    int i = sumRootToLeaf(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new SumOfRootToLeafBinaryNumbers().test();
  }

}
