package com.me.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zs
 * @date 2022/2/21 二叉搜索树的范围和 https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBst {

  boolean flag = true;
  List<Integer> leaf1 = new LinkedList<>();
  List<Integer> leaf2 = new LinkedList<>();

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    process1(root1);
    process2(root2);
    if (leaf1.size() == leaf2.size()) {
      for (int i = 0; i < leaf1.size(); i++) {
        if (leaf1.get(i) != leaf2.get(i)) {
          flag = false;
        }
      }
    } else {
      flag = false;
    }
    return flag;
  }

  void process1(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      leaf1.add(root.val);
    }
    process1(root.left);
    process1(root.right);
  }

  void process2(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      leaf2.add(root.val);
    }
    process2(root.left);
    process2(root.right);
  }

  public void test() {
    Integer[] arr1 = {1, 2};
    Integer[] arr2 = {2, 2};
    TreeNode root1 = TreeNode.constructTree(arr1);
    TreeNode root2 = TreeNode.constructTree(arr2);
    boolean b = leafSimilar(root1, root2);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new RangeSumOfBst().test();
  }

}
