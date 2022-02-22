package com.me.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zs
 * @date 2022/2/21 二叉树的后序遍历 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {
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

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> arr = new ArrayList<>();
    process(root, arr);
    return arr;
  }

  void process(TreeNode root, List<Integer> arr) {
    if (root == null) {
      return;
    }
    process(root.left, arr);
    process(root.right, arr);
    arr.add(root.val);
  }

  public void test() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    List<Integer> arr = postorderTraversal(root);
    System.out.println();
  }

  public static void main(String[] args) {
    new BinaryTreePostorderTraversal().test();
  }
}
