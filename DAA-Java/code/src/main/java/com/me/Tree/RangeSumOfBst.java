package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/21 二叉搜索树的范围和 https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBst {

  int sum = 0;

  public int rangeSumBST(TreeNode root, int low, int high) {
    process(root, low, high);
    return sum;
  }

  void process(TreeNode root, int low, int high) {
    if (root == null) {
      return;
    }
    if (root.val >= low && root.val <= high) {
      sum += root.val;
    }
    process(root.left, low, high);
    process(root.right, low, high);
  }

  public void test() {
    Integer[] arr = {10, 5, 15, 3, 7, null, 18};
    TreeNode root = TreeNode.constructTree(arr);
    int i = rangeSumBST(root, 7, 15);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new RangeSumOfBst().test();
  }

}
