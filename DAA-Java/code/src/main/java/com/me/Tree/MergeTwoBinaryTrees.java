package com.me.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21
 *
 *       合并二叉树
 *
 *       https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null) {
      return root2;
    }
    if (root2 == null) {
      return root1;
    }
    root1.val += root2.val;
    root1.left = mergeTrees(root1.left, root2.left);
    root1.right = mergeTrees(root1.right, root2.right);
    return root1;
  }

  public void test() {
    Integer[] arr1 = {1, 3, 2, 5};
    Integer[] arr2 = {2, 1, 3, null, 4, null, 7};
    TreeNode root1 = TreeNode.constructTree(arr1);
    TreeNode root2 = TreeNode.constructTree(arr2);
    TreeNode node = mergeTrees(root1, root2);
    System.out.println(node);
  }

  public static void main(String[] args) {
    new MergeTwoBinaryTrees().test();
  }

}
