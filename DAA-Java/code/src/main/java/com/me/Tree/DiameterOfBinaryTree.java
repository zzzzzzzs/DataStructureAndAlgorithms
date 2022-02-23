package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/21 二叉树的直径 https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {
  int diameter = 0;

  // 中序遍历不可以，有可能节点都在同一侧，这样就做不到了
  public int diameterOfBinaryTree(TreeNode root) {
    process(root);
    return diameter;
  }

  int process(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftMax = process(root.left);
    int rightMax = process(root.right);
    diameter = Math.max(diameter, leftMax + rightMax);
    return 1 + Math.max(leftMax, rightMax);
  }

  public void test() {
    Integer[] arr = {1, 2, 3};
    TreeNode root = TreeNode.constructTree(arr);
    int i = diameterOfBinaryTree(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new DiameterOfBinaryTree().test();
  }

}
