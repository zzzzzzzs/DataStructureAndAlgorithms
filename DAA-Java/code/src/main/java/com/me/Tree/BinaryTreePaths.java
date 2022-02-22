package com.me.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zs
 * @date 2022/2/22 二叉树的所有路径 https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  LinkedList<String> paths = new LinkedList<>();
  LinkedList<String> res = new LinkedList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    process(root);
    return res;
  }

  void process(TreeNode root) {
    if (root == null) {
      return;
    }
    // 叶子节点
    if (root.left == null && root.right == null) {
      paths.addLast(root.val + "");
      res.add(String.join("->", paths));
      paths.removeLast();
      return;
    }
    paths.addLast(root.val + "");
    process(root.left);
    process(root.right);
    paths.removeLast();
  }

  public void test() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    List<String> strings = binaryTreePaths(root);
    System.out.println();
  }

  public static void main(String[] args) {
    new BinaryTreePaths().test();
  }
}
