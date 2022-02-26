package com.me.Tree;

/**
 * 将有序数组转换为二叉搜索树
 * 
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * 高度平衡二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class ConvertSortedArrayToBinarySearchTree {
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

  // 数组是中序遍历的结果
  public TreeNode sortedArrayToBST(int[] nums) {
    return process(nums, 0, nums.length - 1);
  }

  TreeNode process(int[] nums, int L, int R) {
    if (L > R) {
      return null;
    }
    int mid = (L + R) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = process(nums, L, mid - 1);
    node.right = process(nums, mid + 1, R);
    return node;
  }

  void test() {
    int[] arr = {-10, -3, 0, 5, 9};
    TreeNode node = sortedArrayToBST(arr);
    System.out.println();
  }

  public static void main(String[] args) {
    new ConvertSortedArrayToBinarySearchTree().test();
  }
}
