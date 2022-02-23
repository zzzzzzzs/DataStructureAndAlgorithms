package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/21 根据二叉树创建字符串 https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
public class ConstructStringFromBinaryTree {

  public String tree2str(TreeNode root) {
    if (root == null) return "";
    if (root.left == null && root.right == null) {
      return root.val + "";
    }
    String leftStr = tree2str(root.left);
    String rightStr = tree2str(root.right);

    if (root.left != null && root.right == null) {
      // 省略空的右子树
      return root.val + "(" + leftStr + ")";
    }
    if (root.left == null && root.right != null) {
      // 空的左子树不能省略
      return root.val + "()" + "(" + rightStr + ")";
    }
    // 按题目要求处理 root 左右子树都不空的情况
    return root.val + "(" + leftStr + ")" + "(" + rightStr + ")";
  }

  public void test() {
    Integer[] arr = {1, 2, 3, 4};
    TreeNode root = TreeNode.constructTree(arr);
    String str = tree2str(root);
    System.out.println(str);
  }

  public static void main(String[] args) {
    new ConstructStringFromBinaryTree().test();
  }

}
