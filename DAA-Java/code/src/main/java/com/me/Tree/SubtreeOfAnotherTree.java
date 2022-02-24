package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21
 * 
 *       另一棵树的子树
 * 
 *       https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class SubtreeOfAnotherTree {

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return subRoot == null;
    }
    if (isSameTree(root, subRoot)) {
      return true;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public void test() {
    Integer[] arr1 = {3, 4, 5, 1, 2};
    Integer[] arr2 = {4, 1, 2};
    TreeNode root = TreeNode.constructTree(arr1);
    TreeNode subRoot = TreeNode.constructTree(arr2);
    boolean b = isSubtree(root, subRoot);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new SubtreeOfAnotherTree().test();
  }

}
