package com.me.Tree;

/**
 * 二叉搜索树的最小绝对差
 * 
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceInBst {

  TreeNode pre = null;
  int minValue = Integer.MAX_VALUE;

  // 使用中序遍历，计算两个节点之间的差值
  public int getMinimumDifference(TreeNode root) {
    process(root);
    return minValue;
  }

  void process(TreeNode root) {
    if (root == null)
      return;
    process(root.left);
    if (pre != null) {
      minValue = Math.min(minValue, Math.abs(pre.val - root.val));
    }
    pre = root;
    process(root.right);
  }

  public void test() {
    Integer[] arr = {1,0,48,null,null,12,49};
    TreeNode root = TreeNode.constructTree(arr);
    int i = getMinimumDifference(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new MinimumAbsoluteDifferenceInBst().test();
  }

}
