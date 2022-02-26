package com.me.Tree;

/**
 * 验证二叉搜索树
 * 
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

  TreeNode pre = null;

  // 中序遍历，二叉树的中序遍历是从小到大的
  public boolean isValidBST(TreeNode root) {
    if (root == null)
      return true;
    boolean left = isValidBST(root.left);
    if (pre != null && pre.val >= root.val) {
      return false;
    }
    pre = root;
    boolean right = isValidBST(root.right);
    return left && right;
  }

  public void test() {
    Integer[] arr = {0, -1};
    TreeNode root = TreeNode.constructTree(arr);
    boolean b = isValidBST(root);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new ValidateBinarySearchTree().test();
  }

}
