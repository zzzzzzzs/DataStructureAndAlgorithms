package com.me.Tree;

import java.util.*;

/**
 * @author zs
 * @date 2022/2/22 二叉搜索树中的众数 https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class FindModeInBinarySearchTree {
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

  Map<Integer, Integer> map = new HashMap<>();

  public int[] findMode(TreeNode root) {
    process(root);
    Integer o = (Integer)map.values().stream().sorted((o1, o2) -> o2 - o1).toArray()[0];
    List<Integer> list = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if ((Integer)entry.getValue() == o) {
        list.add(entry.getKey());
      }
    }
    int[] arr = new int[list.size()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }

  void process(TreeNode root) {
    if (root == null) {
      return;
    }
    if (map.containsKey(root.val)) {
      map.put(root.val, map.get(root.val) + 1);
    } else {
      map.put(root.val, 1);
    }
    process(root.left);
    process(root.right);
  }

  public void test() {
    TreeNode root = new TreeNode(0);
//    root.right = new TreeNode(2);
//    root.right.left = new TreeNode(2);
    int[] mode = findMode(root);
    System.out.println();
  }

  public static void main(String[] args) {
    new FindModeInBinarySearchTree().test();
  }
}
